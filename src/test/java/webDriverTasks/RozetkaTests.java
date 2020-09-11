package test.java.webDriverTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class RozetkaTests {
    WebDriver driver;
    WebDriverWait wait;
    String [] expectedBorderColorArray = {
            "rgb(251, 119, 119)",
            "rgb(255, 120, 120)",
            "rgb(254, 121, 121)",
            "rgb(216, 107, 107)",
            "rgb(247, 117, 117)",
            "rgb(246, 117, 117)",
            "rgb(248, 118, 118)",
            "rgb(239, 113, 113)",
            "rgb(255, 119, 120)",
    };
    By signInBtnBy = By.cssSelector("[name='signin']");
    By registerBtnBy = By.cssSelector("[class='auth-f-signup']");
    By registerTitleInputBy = By.cssSelector("input[name='title']");
    By registerLoginInputBy = By.cssSelector("input[name='login']");
    By registerPasswordInputBy = By.cssSelector("input[name='password']");
    By registerSubmitBtnBy = By.cssSelector("div[class='signup-submit']");
    By registerInputInvalidBy = By.cssSelector("input[class='input-text auth-input-text input-invalid']");


    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/");
        wait = new WebDriverWait(driver, 10, 500);
        wait.until(ExpectedConditions.elementToBeClickable(signInBtnBy));
        driver.findElement(signInBtnBy).click();
        wait.until(ExpectedConditions.elementToBeClickable(registerBtnBy));
        driver.findElement(registerBtnBy).click();
        wait.until(ExpectedConditions.and(
                ExpectedConditions.elementToBeClickable(registerTitleInputBy),
                ExpectedConditions.elementToBeClickable(registerLoginInputBy),
                ExpectedConditions.elementToBeClickable(registerPasswordInputBy),
                ExpectedConditions.elementToBeClickable(registerSubmitBtnBy)
        ));

    }

    @Test
    public void registrationWithEmptyFields() {
        driver.findElement(registerTitleInputBy).click();
        driver.findElement(registerLoginInputBy).click();
        driver.findElement(registerPasswordInputBy).click();
        driver.findElement(registerSubmitBtnBy).click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(registerInputInvalidBy));

        String actualInputBorderColor = driver.findElement(registerInputInvalidBy).getCssValue("border-color");
        int actualAmountOfInvalidInputs = driver.findElements(registerInputInvalidBy).size();

        int expectedAmountOfInvalidInputs = 3;
        assertTrue(Arrays.stream(expectedBorderColorArray).anyMatch(t -> t.equals(actualInputBorderColor)));
        assertEquals(actualAmountOfInvalidInputs, expectedAmountOfInvalidInputs);
    }

    @Test
    public void registrationWithInvalidEmail() {
        driver.findElement(registerTitleInputBy).sendKeys("Имя");
        driver.findElement(registerLoginInputBy).sendKeys("invalidemail");
        driver.findElement(registerPasswordInputBy).sendKeys("12345Te$t!");
        driver.findElement(registerSubmitBtnBy).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(registerInputInvalidBy));

        String actualInputBorderColor = driver.findElement(registerLoginInputBy).getCssValue("border-color");
        int actualAmountOfInvalidInputs = driver.findElements(registerInputInvalidBy).size();
        int expectedAmountOfInvalidInputs = 1;

        assertEquals(actualAmountOfInvalidInputs, expectedAmountOfInvalidInputs);
        assertTrue(Arrays.stream(expectedBorderColorArray).anyMatch(t -> t.equals(actualInputBorderColor)));
        assertFalse(Arrays.asList(
                driver.findElement(registerTitleInputBy).getAttribute("class")
                        .split(" ")).contains("input-invalid"));
        assertFalse(Arrays.asList(
                driver.findElement(registerPasswordInputBy).getAttribute("class")
                        .split(" ")).contains("input-invalid"));
    }

    @Test(dataProvider = "testPassword")
    public void registrationWithInvalidPassword(String password) {
        driver.findElement(registerTitleInputBy).sendKeys("Имя");
        driver.findElement(registerLoginInputBy).sendKeys("invalidemail@gmail.com");
        driver.findElement(registerPasswordInputBy).sendKeys(password);
        driver.findElement(registerSubmitBtnBy).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(registerInputInvalidBy));

        String actualInputBorderColor = driver.findElement(registerPasswordInputBy).getCssValue("border-color");
        int actualAmountOfInvalidInputs = driver.findElements(registerInputInvalidBy).size();
        int expectedAmountOfInvalidInputs = 1;

        assertTrue(Arrays.stream(expectedBorderColorArray).anyMatch(t -> t.equals(actualInputBorderColor)));
        assertEquals(actualAmountOfInvalidInputs, expectedAmountOfInvalidInputs);
        assertFalse(Arrays.asList(
                driver.findElement(registerTitleInputBy).getAttribute("class")
                        .split(" ")).contains("input-invalid"));
        assertFalse(Arrays.asList(
                driver.findElement(registerLoginInputBy).getAttribute("class")
                        .split(" ")).contains("input-invalid"));
    }

    @DataProvider(name = "testPassword")
    public Object[][] provider() {
        return new Object[][] {
                {"1234"},
                {"1234@test"},
                {"1234@!"},
                {"testtest"},
                {"@#%$^*!()"},
        };
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

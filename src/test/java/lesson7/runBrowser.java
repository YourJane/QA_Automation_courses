package test.java.lesson7;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class runBrowser {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
//        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/ua/notebooks/c80004/");

        By city = By.cssSelector("a[class='header-cities__link link-dashed']");

        Thread.sleep(5000);
        String cityValue = driver.findElement(city).getText();
        System.out.println(cityValue);

        WebElement producerInput = driver.findElement(By.cssSelector("*[data-filter-name='producer'] input[name='searchline']"));
        producerInput.sendKeys("Apple");

        Thread.sleep(5000);

//        producerInput.clear();
        producerInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        producerInput.sendKeys(Keys.BACK_SPACE);

        Actions builder = new Actions(driver);
        builder.keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL).build().perform();

        for (String window: driver.getWindowHandles()) driver.switchTo().window(window);

        driver.quit();

    }
}

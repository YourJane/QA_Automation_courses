package test.java.PageObject.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestsSetup {
    WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(ITestContext testContext, String browser) {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        FirefoxOptions foxOptions = new FirefoxOptions();
//        driver = new ChromeDriver(options);
        if (browser.equalsIgnoreCase("Chrome")){
            try {
                driver = new RemoteWebDriver(new URL(
                        "http://ec2-34-245-36-135.eu-west-1.compute.amazonaws.com:4444/wd/hub"),
                        options);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        if (browser.equalsIgnoreCase("Firefox")){
            try {
                driver = new RemoteWebDriver(new URL(
                        "http://ec2-34-245-36-135.eu-west-1.compute.amazonaws.com:4444/wd/hub"),
                        foxOptions);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MILLISECONDS);
        testContext.setAttribute("driver", driver);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
//        Screenshots screenshot = new Screenshots(driver);
//        screenshot.makeScreenshot(result);
        driver.quit();
    }

}

package test.java.webDriverTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RunBrowserTask {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua");

        String mainPhone = driver.findElement(By.xpath("//*[@class='header-phones-i bold']")).getText();

        System.out.println(extractDigits(mainPhone));

        driver.quit();
    }

    public static String extractDigits(String src) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < src.length(); i++) {
            char character = src.charAt(i);
            if (Character.isDigit(character)) {
                builder.append(character);
            }
        }
        return builder.toString();
    }
}

package test.java.PageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.java.PageObject.utils.PropertyLoader;

import java.util.List;

public class HomePage extends BasePage {
    WebDriver driver;
    By searchInputBy = By.cssSelector("input[class='rz-header-search-input-text passive']']");
    By searchBtnBy = By.cssSelector("button[class='btn-link-i js-rz-search-button']");
    By langPopupBy = By.cssSelector("div[class='popup-css lang-switcher-popup sprite-side']");
    By closePopupBtnBy = By.cssSelector("a[class='popup-close']");

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public HomePage open() {
        this.logger.info("Home page was opened");
        driver.get(PropertyLoader.loadProperty("baseurl"));
        return this;
    }

    public HomePage closePopup() {
        List<WebElement> check = driver.findElements(langPopupBy);
        if (check.size() > 0) {
            WebElement closePopupBtn = driver.findElement(closePopupBtnBy);
            closePopupBtn.click();
            this.logger.info("Popup 'try language' was closed");
        }
        return this;
    }


    public HomePage search(String query) {
        this.logger.warn("Warn");
        this.logger.error("Error");
        this.logger.info("Search request was sent.");
        wait.until(ExpectedConditions.elementToBeClickable(searchInputBy));
        WebElement searchInput = driver.findElement(searchInputBy);
        searchInput.sendKeys(query);
        WebElement searchBtn = driver.findElement(searchBtnBy);
        searchBtn.click();
        return this;
    }
}

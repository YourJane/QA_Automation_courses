package test.java.PageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.java.PageObject.utils.PropertyLoader;

import java.util.List;

public class ViewProductsPage extends BasePage{
    WebDriver driver;
    By productsTitlesNameBy = By.cssSelector("span[class='goods-tile__title']");
    By productsTitlesBrandBy = By.cssSelector("div[class='g-i-tile-i-title clearfix'] a");
    By filterByBrandsBy = By.cssSelector("li[class='checkbox-filter__item'] label");

    public ViewProductsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Override
    public ViewProductsPage open() {
        this.logger.info("View notebook page was open.");
        driver.get(PropertyLoader.loadProperty("category.notebook.url"));
        return this;
    }

    public List<WebElement> getFilterByBrandList() {
        this.logger.debug("Debug");
        this.logger.info("Got the list of the webElements with brands to filter by.");
        List<WebElement> filterByBrands = driver.findElements(filterByBrandsBy);
        wait.until(ExpectedConditions.elementToBeClickable(filterByBrandsBy));
        return filterByBrands;
    }

    public ViewProductsPage clickOnFilter (String filterName) {
        this.logger.warn("Warn");
        this.logger.error("Error");
        this.logger.info("Clicked on the checkbox to filter by brad " + filterName);
        wait.until((ExpectedConditions.elementToBeClickable(filterByBrandsBy)));
        By filterByBrandBy = By.xpath(
                "//li[@class='checkbox-filter__item']//a//label[contains(text(),'" + filterName + "')]");
        WebElement filterByBrand = driver.findElement(filterByBrandBy);
        wait.until((ExpectedConditions.elementToBeClickable(filterByBrand)));
        filterByBrand.click();
        wait.until(ExpectedConditions.elementToBeClickable(productsTitlesNameBy));
        return this;
    }

    public List<WebElement> getProductsTitlesByName() {
        List<WebElement> productsTitles = driver.findElements(productsTitlesNameBy);
        wait.until(ExpectedConditions.elementToBeClickable(productsTitlesNameBy));
        return productsTitles;
    }

    public List<WebElement> getProductsTitlesByBrand() {
        List<WebElement> productsTitles = driver.findElements(productsTitlesBrandBy);
        wait.until(ExpectedConditions.elementToBeClickable(productsTitlesBrandBy));
        return productsTitles;
    }

}

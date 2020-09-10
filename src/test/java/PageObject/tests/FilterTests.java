package test.java.PageObject.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.PageObject.pages.ViewProductsPage;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class FilterTests extends TestsSetup{
    ViewProductsPage viewProductsPage;

    @BeforeMethod
    public void pageFactory() {
        viewProductsPage = new ViewProductsPage(driver);
    }

    @Test
    public void FilterByBrand(String brandName){
        viewProductsPage
                .open()
                .clickOnFilter(brandName);
        List<WebElement> foundProductsTitles = viewProductsPage.getProductsTitlesByName();
        for (WebElement foundProductsTitle: foundProductsTitles){
            String actualResult = foundProductsTitle.getText().toLowerCase();
            assertTrue(
                    actualResult.contains(brandName.toLowerCase()),
                    String.format("Expected %s to contain %s", actualResult, brandName));
        }
    }

}

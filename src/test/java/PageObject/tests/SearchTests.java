package test.java.PageObject.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.java.PageObject.pages.HomePage;
import test.java.PageObject.pages.ViewProductsPage;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class SearchTests extends TestsSetup{
    HomePage homePage;
    ViewProductsPage viewProductsPage;

    @BeforeMethod
    public void pageFactory() {
        homePage = new HomePage(driver);
        viewProductsPage = new ViewProductsPage(driver);
    }

    @Test(dataProvider = "searchQueriesNames")
    public void searchForProductByName(String query){
        homePage
                .open()
                .closePopup()
                .search(query);
        List<WebElement> foundProductsTitles = viewProductsPage.getProductsTitlesByName();
        for (WebElement foundProductsTitle: foundProductsTitles){
            String actualResult = foundProductsTitle.getText();;
            assertTrue(
                    actualResult.contains(query),
                    String.format("Expected %s to contain %s", actualResult, query));
        }
    }

    @Test
    public void searchForProductByBrand(){
        homePage
                .open()
                .closePopup()
                .search("Samsung");
        List<WebElement> foundProductsTitles = viewProductsPage.getProductsTitlesByBrand();
        for (WebElement foundProductsTitle: foundProductsTitles){
            String actualResult = foundProductsTitle.getAttribute("href");
            assertTrue(
                    actualResult.contains("samsung"),
                    String.format("Expected %s to contain 'samsung'", actualResult));
        }
    }

    @DataProvider(name = "searchQueriesNames")
    public Object[][] provider() {
        return new Object[][] {
                {"iPhone"},
                {"Galaxy"},
        };
    }

}

package test.java.PageObject.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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

    @Test(dataProvider = "brandsNames")
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

    @DataProvider(name = "brandsNames")
    public Object[][] provider() {
        return new Object[][] {
                {"blabla"},
//                {"Acer"},
//                {"Apple"},
//                {"Asus"},
//                {"Dell"},
//                {"Dream Machines"},
//                {"HP"},
//                {"Huawei"},
//                {"Lenovo"},
//                {"MSI"},
//                {"Microsoft"},
//                {"Razer"},
//                {"Xiaomi"},
//                {"Alien"},
//                {"Chuwi"},
//                {"Compaq"},
//                {"Digma"},
//                {"Durabook"},
//                {"Epic"},
//                {"Fujitsu"},
//                {"Fujitsu-siemens"},
//                {"Gigabyte"},
//                {"Google"},
//                {"Jumper"},
//                {"Mediacom"},
//                {"Medion"},
//                {"Mixzo"},
//                {"NuVision"},
//                {"Odys"},
//                {"Panasonic"},
//                {"Porsche Design"},
//                {"Prestigio"},
//                {"RCA"},
//                {"Teclast"},
//                {"Toshiba"},
//                {"Vinga"},
                {"Yepo"}
        };
    }

}

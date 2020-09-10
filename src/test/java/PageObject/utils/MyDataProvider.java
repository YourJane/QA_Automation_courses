package test.java.PageObject.utils;

import org.testng.annotations.DataProvider;

public class MyDataProvider {
    @DataProvider
    public Object[][] searchQueriesNames() {
        return new Object[][] {
                {"iPhone"},
                {"Galaxy"},
        };
    }
    @DataProvider
    public Object[][] brandsNames() {
        return new Object[][] {
                {"Acer"},
                {"Apple"},
                {"Asus"},
                {"Dell"},
                {"Dream Machines"},
                {"HP"},
                {"Huawei"},
                {"Lenovo"},
                {"MSI"},
                {"Microsoft"},
                {"Razer"},
                {"Xiaomi"},
                {"Alien"},
                {"Chuwi"},
                {"Compaq"},
                {"Digma"},
                {"Durabook"},
                {"Epic"},
                {"Fujitsu"},
                {"Fujitsu-siemens"},
                {"Gigabyte"},
                {"Google"},
                {"Jumper"},
                {"Mediacom"},
                {"Medion"},
                {"Mixzo"},
                {"NuVision"},
                {"Odys"},
                {"Panasonic"},
                {"Porsche Design"},
                {"Prestigio"},
                {"RCA"},
                {"Teclast"},
                {"Toshiba"},
                {"Vinga"},
                {"Yepo"}
        };
    }
}

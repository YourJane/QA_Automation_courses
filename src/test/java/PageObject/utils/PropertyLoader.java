package test.java.PageObject.utils;

import java.util.ResourceBundle;

public class PropertyLoader {

    public static String loadProperty(String name) {
        return ResourceBundle.getBundle("config").getString(name);
    }

    public static String loadCredential(String name) {
        return ResourceBundle.getBundle("secure-config").getString(name);
    }
}

package test.java.PageObject.utils;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationTransformer implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
        iTestAnnotation.setRetryAnalyzer(RetryAnalyzer.class);
        if (method.getName().equalsIgnoreCase("searchForProductByName")) {
            iTestAnnotation.setDataProviderClass(MyDataProvider.class);
            iTestAnnotation.setDataProvider("searchQueriesNames");
        }
        if (method.getName().equalsIgnoreCase("FilterByBrand")) {
            iTestAnnotation.setDataProviderClass(MyDataProvider.class);
            iTestAnnotation.setDataProvider("brandsNames");
        }
    }
}

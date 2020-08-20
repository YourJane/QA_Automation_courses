package test.java.testngTasks;

import main.java.lesson3.Task_5;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Task_5_tests {
    Task_5 task = new Task_5();

    @Test(dataProvider = "testStrings")
    public void getReversed (String testString, String expectedResult) {
        String actualResult = task.reverse(testString);
        assertEquals(actualResult, expectedResult, String.format("Expected %s", expectedResult));
    }

    @DataProvider(name = "testStrings")
    public Object[][] provider() {
        return new Object[][] {
                {"ylnOtxeT", "TextOnly"},
                {"secaps dna txeT", "Text and spaces"},
                {"lobmys + txeT", "Text + symbol"},
                {"54321", "12345"}
        };
    }

}

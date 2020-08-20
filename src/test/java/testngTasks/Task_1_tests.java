package test.java.testngTasks;

import main.java.lesson3.Task_1;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Task_1_tests {
    Task_1 task = new Task_1();

    @Test(dataProvider = "dataInts")
    public void getMinInt(int firstInt, int secondInt, int thirdInt, int expectedResult) {
        int actualResult = task.min(firstInt, secondInt, thirdInt);
        assertEquals(
                actualResult, expectedResult,
                String.format("Expected min to be %d", expectedResult));
    }

    @DataProvider(name = "dataInts")
    public Object[][] provider() {
        return new Object[][] {
                {8, 10, 16, 8},
                {0, -1, 23, -1},
                {-12, -10, -19, -19},
                {0, 0, 0, 0}
        };
    }
}

package test.java.testngTasks;

import main.java.lesson3.Task_2;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Task_2_tests {
    Task_2 task = new Task_2();

    @Parameters({"usersName"})
    @Test
    public void countRows (String usersName) {
        int expectedResult = 5;
        int actualResult = task.multipleName(usersName).split("\n").length;
        assertEquals(actualResult, expectedResult, String.format("Expected %d rows", expectedResult));
    }

    @Parameters({"usersName"})
    @Test
    public void countRowLength (String usersName) {
        String rows[] = task.multipleName(usersName).split("\n");
        for (String row: rows) {
            int expectedResult = 10;
            int actualResult = row.split(" ").length;
            assertEquals(actualResult, expectedResult,
                    String.format("Expected length for a row is %d ", expectedResult));
        }
    }
}

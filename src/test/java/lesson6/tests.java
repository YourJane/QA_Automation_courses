//package test.java.lesson6;
//
//import main.java.lesson4.Cat;
//import org.testng.annotations.*;
//
//import static org.testng.Assert.assertEquals;
//
//public class tests {
//    Cat cat;
//    String result = "";
//
//    @BeforeClass
//    public void beforeAllMethods() {
//        cat = new Cat("Marvel");
//        result = cat.getMatrix();
//    }
//
//    @BeforeMethod
//    public void setUp() {
//        System.out.println("hello");;
//    }
//
////    @BeforeGroups()
////    public void beforeGetMatrixTests() {
////        result = cat.getMatrix();
////    }
//
//    @AfterMethod
//    public void tearDown() {
//        System.out.println("buy");
//    }
//
//    @AfterClass
//    public void afterAllMethods() {
//        System.out.println("Have a nice day");
//    }
//
//    @Test(dataProvider = "dp")
//    public void getCatAge(int ageToChange, int expectedAge) {
//        Cat cat = new Cat();
//        cat.setAge(ageToChange);
//        int actualAge = cat.getAge();
//        assertEquals(actualAge, expectedAge, String.format("Expected age to be %d", expectedAge));
//    }
//
//    @Test(groups = "getMatrix")
//    public void getMatrixRowAmount() {
//        int expectedRowAmount = 5;
//        int actualRowAmount = result.split("\n").length;
//        assertEquals(actualRowAmount, expectedRowAmount);
//    }
//
//    @Test(groups = "getMatrix")
//    public void getMatrixRowLength() {
//        String rows[] = result.split("\n");
//        for (String row: rows) {
//            int expectedRowLength = 5;
//            int actualRowLength = row.split(" ").length;
//            assertEquals(expectedRowLength, actualRowLength);
//        }
//    }
//
//    @DataProvider(name = "dp")
//    public Object[][] provider() {
//        return new Object[][] {
//                {-1, 20},
//                {0, 20},
//                {1, 1},
//                {10, 10},
//                {21, 21},
//                {22, 20}
//        };
//    }
//}

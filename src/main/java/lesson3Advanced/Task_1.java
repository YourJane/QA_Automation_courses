package lesson3Advanced;

public class Task_1 {
    public static void main(String[] args) {
        int[] intArray = {12, 4, 6, 34, 90, 23, -19, 89, 3};
        System.out.println(min(intArray));
    }

    public static int min(int[] integers) {
        int minValue = integers[0];
        for (int i = 0; i < integers.length; i++){
            if (integers[i] < minValue) {
                minValue = integers[i];
            }
        }
        return minValue;
    }
}



package lesson3;

public class Task_5 {
    public static void main(String[] args) {
        System.out.println(reverse("Hello world!!!"));
    }

    public static String reverse(String str) {
        String reversedString = "";
        char strAsArray [] = str.toCharArray();

        for (int i = strAsArray.length - 1; i != -1; i = i - 1) {
            reversedString += Character.toString(strAsArray[i]);
        }

        return reversedString;
    }
}

package main.java.lesson3Advanced;

public class Task_2 {

    public static void main(String[] args) {
        String s = "*";
        for (int i = 0; i < 10; i ++) {
            for (int c = 0; c < i; c ++) {
                System.out.print(s);
            }
            System.out.println(s);
        }

    }
}

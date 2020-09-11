package main.java.lesson3Advanced;

public class Task_3 {

    public static void main(String[] args) {
        int num = 10;
        for (int i = 1; i <= num; i ++) {
            String space = (i == num) ? "" : String.format("%" + (num - i) + "s", " ");
            String star = String.format("%" + i + "s", "*").replace(' ', '*');
            System.out.println(space + star);
        }
    }
}
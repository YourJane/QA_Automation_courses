package main.java.lesson3;

public class Task_1 {
    public static void main(String[] args) {
        System.out.println("Minimal integer is: " + min(8, 10, 16));
    }

    public static int min(int usersFirstInt, int usersSecondInt, int usersThirdInt) {
        if (usersFirstInt >= usersSecondInt && usersThirdInt >= usersSecondInt) {
            return usersSecondInt;
        } else if (usersFirstInt <= usersSecondInt && usersFirstInt <= usersThirdInt) {
            return usersFirstInt;
        } else {
            return usersThirdInt;
        }
    }
}
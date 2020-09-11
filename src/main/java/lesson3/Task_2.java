package main.java.lesson3;

public class Task_2 {
    public static void main(String[] args) {
        System.out.println(multipleName("Jane"));
    }

    public static String multipleName(String usersName) {
        String joinedUsersName = "";
        for (int r = 0; r < 5; r++) {
            for (int i = 0; i < 10; i++) {
                joinedUsersName += usersName + " ";
            }
            joinedUsersName += "\n";
        }
        return joinedUsersName;
    }
}
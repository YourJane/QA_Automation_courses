package main.java.lesson3;

public class Task_3 {
    public static void main(String[] args) {

        String usersName = "Jane" + " ";
        String joinedUsersName = "";
        int countName = 0;
        int countLines = 0;

        while (countName != 10) {
            joinedUsersName += usersName;
//            joinedUsersName += " ";
            countName ++;
        }

        while (countLines != 5) {
            System.out.println(joinedUsersName);
            countLines ++;
        }
//        Alternative solution using one for and Collection:
//        while (countLines != 5) {
//            String joinedUsersName = String.join(" ", Collections.nCopies(10, usersName));
//            System.out.println(joinedUsersName);
//        }

    }
}

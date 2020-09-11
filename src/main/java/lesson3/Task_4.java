package main.java.lesson3;

public class Task_4 {
    public static void main(String[] args) {

        String usersName = "Jane" + " ";
        String joinedUsersName = "";
        int countName = 0;
        int countLines = 0;

        do {
            joinedUsersName += usersName;
//            joinedUsersName += " ";
            countName ++;
        } while (countName != 10);

        do {
            System.out.println(joinedUsersName);
            countLines ++;
        } while (countLines != 5);

//        Alternative solution using one for and Collection:
//        do {
//            String joinedUsersName = String.join(" ", Collections.nCopies(10, usersName));
//            System.out.println(joinedUsersName);
//        } while (countLines != 5);

    }
}

package lesson3;

public class Task_2 {
    public static void main(String[] args) {

        String usersName = "Jane" + " ";
        String joinedUsersName = "";

        for (int i = 0; i < 10; i++) {
            joinedUsersName += usersName;
//            joinedUsersName += " ";
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(joinedUsersName);
        }

//       Alternative solution using one for and Collection:
//        for (int i = 0; i < 5; i++) {
//            String joinedUsersName = String.join(" ", Collections.nCopies(10, usersName));
//            System.out.println(joinedUsersName);
//        }
    }
}
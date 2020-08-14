package main.java.lesson3Advanced;

public class Task_4 {

    public static void main(String[] args) {
        String lowestVersion = minVersion("1.0.0.1.2", "1.0.0.2.2");
        System.out.println(lowestVersion);
    }

    public static String minVersion(String v1, String v2) {
        String versionOne = v1.replace(".", "");
        String versionTwo = v2.replace(".", "");
        int numberOne = Integer.parseInt(versionOne);
        int numberTwo = Integer.parseInt(versionTwo);
        if (numberOne > numberTwo) {
            return v2;
        } else {
            return v1;
        }
    }
}
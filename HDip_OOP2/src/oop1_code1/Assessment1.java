package oop1_code1;

import java.util.Scanner;

public class Assessment1 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter your age ");
        int age = sc.nextInt();

        boolean okToWatchFilm = admitToFilm(age);
        if (okToWatchFilm) {
            System.out.println("Enjoy the film!");
        } else {
            System.out.println("Sorry, you cannot watch this film.");
        }

        switchPrime();
        forStars();
    }

    public static void forStars() {
        System.out.print("How many stars? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {// 1..n
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = n; i >= 1; i--) {// n..1
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void switchPrime() {
        System.out.print("Enter a number (1..20): ");
        int n = sc.nextInt();

        if (n >= 1 && n <= 20) {
            // valid number
            switch (n) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 11:
                case 13:
                case 17:
                case 19:
                    System.out.println(n + " is a prime number");
                    break;
                default:
                    System.out.println(n + " is not a prime number");
                    break;
            }
        } else {
            System.out.println(n + " is out of range 1..20");
        }
    }

    public static boolean admitToFilm(int age) {
        if (age >= 15) {
            return true;
        } else {
            System.out.print("Is there an adult with you (true/false) ? ");
            return sc.nextBoolean();
        }
    }

}

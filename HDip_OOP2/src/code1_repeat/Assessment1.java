package code1_repeat;

import java.util.Scanner;

public class Assessment1 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean ok = okToDrive();
        if (ok) {
            System.out.println("Enjoy driving!");
        } else {
            System.out.println("Sorry, you are not allowed drive.");
        }

        switchPosNeg();

        System.out.print("How many crosses? ");
        int n = sc.nextInt();
        nestedLoops(n);
    }

    public static void nestedLoops(int n) {
        // for section
        for (int i = 1; i <= n; i++) {// 1..n
            for (int j = 1; j <= i; j++) {
                System.out.print("+");
            }
            System.out.println();
        }
        
        // while section
        int i=1;
        while(i <= n){
            int j=1;
            while(j <= i){
                System.out.print("+");
                j++;
            }
            System.out.println();
            i++;
        }
    }

    public static void switchPosNeg() {
        System.out.print("Enter a number (-10..+10): ");
        int n = sc.nextInt();

        if (n >= -10 && n <= 10) {
            // valid number
            switch (n) {
                case 0:
                        System.out.println("For JAVA zero is a positive number too!");
                        break;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                    System.out.println(n + " is a positive number");
                    break;
                default:
                    System.out.println(n + " is a negative number");
                    break;
            }
        } else {
            System.out.println(n + " is out of range -10..+10");
        }
    }

    public static boolean okToDrive() {
        System.out.print("Do you have a full licence (true/false) ? ");
        boolean fullLicence = sc.nextBoolean();
        if (fullLicence) {
            return true;
        } else {
            System.out.print("Do you have a provisional licence (true/false) ? ");
            boolean provisionalLicence = sc.nextBoolean();
            if (provisionalLicence) {
                System.out.print("Is there an adult with you (true/false) ? ");
                return sc.nextBoolean();
            } else {
                //System.out.print("You cannot drive without some form of licence! ");
                return false; 
            }
        }
    }

}

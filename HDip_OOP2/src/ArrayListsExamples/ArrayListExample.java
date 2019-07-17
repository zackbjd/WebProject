package ArrayListsExamples;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample {
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        ArrayList<String> destinations = new ArrayList<>();
        final int ADD=1, UPDATE=2, DELETE=3, DISPLAY=4, EXIT=5;
        String userContinue="y";
        while(userContinue.equalsIgnoreCase("y")){
            switch(userChoice()){
                case ADD:
                    String dest = add();
                    destinations.add(dest);
                    break;
                case UPDATE:
                    update(destinations);
                    break;
                case DELETE:
                    delete(destinations);
                    break;
                case DISPLAY:
                    display(destinations);
                    break;
                case EXIT:
                    userContinue="n";
                    break;
                default:
                    System.out.println("Unknown value ");
                    break;
            }
        }
    }
    public static void update(ArrayList<String> destAL){
        System.out.println("The destinations before: "+destAL);
        
        System.out.print("Enter index to update --> ");
        int index = sc.nextInt();
        System.out.print("Enter the new destination --> ");
        String newDest = sc.next();
        destAL.set(index, newDest);
        
        System.out.println("The destinations after: "+destAL);
    }
    public static void delete(ArrayList<String> destAL){
        System.out.println("The destinations before: "+destAL);
        
        System.out.print("Enter index to delete --> ");
        int index = sc.nextInt();
        destAL.remove(index);
        
        System.out.println("The destinations after: "+destAL);
    }
    public static void display(ArrayList<String> destAL){
        System.out.println("The destinations are: ");
        for(String dest:destAL){
            System.out.println(dest);
        }
    }
    public static String add(){
        System.out.println("Enter a destination to add --> ");
        return sc.next();
    }
    public static int userChoice(){
        System.out.println("Holiday destinations program. ");
        System.out.println("1. Add");
        System.out.println("2. Update");
        System.out.println("3. Delete");
        System.out.println("4. Display");
        System.out.println("5. Exit");
        System.out.print("Enter choice --> ");
        return sc.nextInt();
    }
}

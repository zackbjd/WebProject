package oop1_code2;

import java.util.Scanner;

class Cow{
    // instance variables
    private String theBreed, theGender;
    
    // Constructor
//  new Cow("male", "fresian");
    Cow(String theGender, String aBreed){
        this.theGender=theGender;
        theBreed=aBreed;
    }
    // 'get' methods (accessor methods)
    public String getBreed(){
        return theBreed;
    }
    public String getGender(){
        return theGender;
    }
    // 'set' methods (mutator methods)
    public void setGender(String aGender){
        theGender=aGender;
    }
    public void setBreed(String aBreed){
        theBreed=aBreed;
    }
    @Override
    public String toString(){
        return "Cow: Gender is " + theGender + "; Breed is " + theBreed;
    }
}

class Horse{
    // instance variables
    private String theBreed, theGender;
    
    // Constructor
    Horse(String theGender, String aBreed){
        this.theGender=theGender;
        theBreed=aBreed;
    }
    // 'get' methods (accessor methods)
    public String getBreed(){
        return theBreed;
    }
    public String getGender(){
        return theGender;
    }
    // 'set' methods (mutator methods)
    public void setGender(String aGender){
        theGender=aGender;
    }
    public void setBreed(String aBreed){
        theBreed=aBreed;
    }
    @Override
    public String toString(){
        return "Horse: Gender is " + theGender + "; Breed is " + theBreed;
    }
}

public class Assessment2 {
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        String keepGoing = "yes";
        while(keepGoing.equalsIgnoreCase("yes")){  // while(something_is_true)
            int animalChoice = getAnimalChoice();
            String breed     = getBreed(animalChoice);
            String gender    = getGender();
            
            // now that we have our values to store in our
            // objects instance variables, create the object
            if(animalChoice == 1){ // Horse
                Horse horse = new Horse(gender, breed);
                System.out.println(horse);// toString() call
            }else if (animalChoice == 2){ // Cow
                Cow cow = new Cow(gender, breed);
                System.out.println(cow);// toString() call
            }
            
            // does the user wish to keep going?
            System.out.print("Continue (yes/no) ? ");
            keepGoing = sc.next();
        }
    }

    public static int getAnimalChoice(){
        System.out.print("1. Horse or 2. Cow --> ");
        return sc.nextInt();
    }
    public static String getBreed(int animalChoice){
        if(animalChoice == 1){  // horse
            System.out.print("Shire or Arabian? --> ");
        }else if(animalChoice == 2){  // cow
            System.out.print("Angus or Jersey? --> ");
        }
        String breed = sc.next();
        return breed;
    }
    public static String getGender(){
        System.out.print("Male or Female? -->");
        return sc.next();
    }
}

package ArrayListsExamples;

import java.util.ArrayList;
import java.util.Scanner;

class Person{
    private int age;
    private String name, address;

    Person(int age, String name, String address) {
        this.age = age;
        this.name = name;
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" + "age=" + age + ", name=" + name + ", address=" + address + '}';
    }

    
    
    
}

public class ArrayListSample {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
//        String name = arrayListStringLiterals(); // execute the method
//        System.out.println(name);// Thomas

        //arrayListStringsNoLoops();
        //arrayListStringsWithLoops();
        //arrayListInteger();
        arrayListPerson();
    }
    public static void arrayListPerson(){
        ArrayList<Person> people = new ArrayList<>();
        //people.add("abc"); // compiler error
        while(true){
            System.out.print("Enter name --> ");
            String name = sc.next();
            System.out.print("Enter address --> ");
            String address = sc.next();
            System.out.print("Enter age --> ");
            int age = sc.nextInt();
            
            Person p = new Person(age, name, address);
            people.add(p);
            
            System.out.print("Create more people? (y/n) --> ");
            String userChoice = sc.next();
            if(userChoice.equalsIgnoreCase("n")){
                break; // exit the 'while' loop
            }            
        }
        System.out.println(people);
        
        // Output the ArrayList using an enhanced-for loop
        for(Person p:people){
            System.out.println(p);
        }
    }
    public static void arrayListStringsNoLoops(){
        // generically typed to String
        // diamond operator - type inference
        ArrayList<String> names = new ArrayList<>();

        System.out.print("Enter name --> ");
        String name = sc.next();
        names.add(name);
        System.out.print("Enter name --> ");
        name = sc.next();
        names.add(name);
        System.out.print("Enter name --> ");
        name = sc.next();
        names.add(name);
        System.out.print("Enter name --> ");
        name = sc.next();
        names.add(name);
        
        System.out.println(names);
    }
    public static void arrayListStringsWithLoops(){
        ArrayList<String> names = new ArrayList<>();
        
        System.out.print("Enter name (x to exit) --> ");
        String name = sc.next();
        while(!name.equalsIgnoreCase("x")){
            names.add(name);
            
            // get the next name
            System.out.print("Enter name (x to exit) --> ");
            name = sc.next();
        }
        for(String someone:names){
            System.out.println(someone);
        }
    }
    public static void arrayListInteger(){
        ArrayList<Integer> numbers = new ArrayList<>();
        
        System.out.print("Enter a number (-1 to exit) --> ");
        int n = sc.nextInt();
        while(n != -1){
//            numbers.add(new Integer(n)); // pre Java 1.5
            numbers.add(n); // autoboxing int->Integer
            
            // get the next number
            System.out.print("Enter a number (-1 to exit) --> ");
            n = sc.nextInt();
        }
        for(int number:numbers){ // autoboxing Integer->int
            System.out.println(number); 
        }
    }
    
    public static String arrayListStringLiterals(){
        // ArrayList properties: 
        //   order of insertion maintained, duplicates allowed
        ArrayList<String> names = new ArrayList<>();
        names.add("Zoe");
        //names.add(77);
        names.add("Paul");
        names.add("Paul");
        names.add("Alan");
        names.add("Thomas");
        System.out.println(names);// [Zoe, Paul, Paul, Alan, Thomas]
        
        return names.get(4); // Thomas
    }
    
}

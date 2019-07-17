package ArrayListsExamples;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class Personn{
    private int age;
    private String name;

    Personn(int age, String name) {
        this.age = age;
        this.name = name;
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

    @Override
    public String toString() {
        return "Personn{" + "age=" + age + ", name=" + name + '}';
    }
}

public class ArrayListPeople {
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        List<List<Integer>> t = new ArrayList<List<Integer>>();
        Set set = new TreeSet();
        set.add("1");
        set.add(2);
        set.add("3");
//        for(String s:set){
//            
//        }
//        
        
        ArrayList<Personn> people = new ArrayList<>();
        final int ADD=1, UPDATE=2, DELETE_ONE=3, DELETE_ALL=4,
                  FIND_PERSON_BY_INDEX=5, DISPLAY=6, EXIT=7;
        String userContinue="y";
        while(userContinue.equalsIgnoreCase("y")){
            int choice = userChoice();
            switch(choice){
                case ADD:
                    add(people);
                    break;
                case UPDATE:
                    update(people);
                    break;
                case DELETE_ONE:
                    deletePerson(people);
                    break;
                case DELETE_ALL:
                    deleteEveryone(people);
                    break;
                case FIND_PERSON_BY_INDEX:
                    findPersonByIndex(people);
                    break;
                case DISPLAY:
                    display(people);
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
    public static void add(ArrayList<Personn> people){
        System.out.print("Enter a name --> ");
        String name = sc.next();
        
        // check that the name is not in the AL i.e. do NOT
        // add it a second time
        if(personThereAlready(name, people) >= 0){// found
            System.out.println(name + " already in list ");
        }else{
            // name was not found in list, get the remaining
            // properties and add the new Personn
            System.out.print("Enter the age --> ");
            int age = sc.nextInt();
            Personn p = new Personn(age, name);
            people.add(p);            
        }
    }
    public static int personThereAlready(String name, ArrayList<Personn> people){
        int index=-1;
        
        for(int i=0; i<people.size(); i++){
            Personn p = people.get(i);
            if(p.getName().equalsIgnoreCase(name)){
                index=i;
                break;
            }
        }
        return index;
    }
    public static void update(ArrayList<Personn> people){
        System.out.print("Enter a name --> ");
        String name = sc.next();

        // check that the name is IN the AL i.e. only update
        // it if it exists
        int index = personThereAlready(name, people);
        if(index == -1){// not found
            System.out.println(name + " not in list ");
        }else{
            // retrieve the Personn at that index
            Personn p = people.get(index);
            
            System.out.print("Enter the new name --> ");
            p.setName(sc.next());
            System.out.print("Enter the age --> ");
            int age = sc.nextInt();
            p.setAge(age);

            // update the object (ref) at the 'index'
            //people.set(index, p);
            System.out.println(people);
        }
    }
    public static void deletePerson(ArrayList<Personn> people){
        System.out.println(people);
        
        System.out.print("Enter a name --> ");
        String name = sc.next();

        // check that the name is IN the AL 
        int index = personThereAlready(name, people);
        if(index == -1){// not found
            System.out.println(name + " not in list ");
        }else{
            people.remove(index);
            System.out.println(people);
        }
    }
    public static void deleteEveryone(ArrayList<Personn> people){
        people.clear();
        
        if(people.isEmpty()){
            System.out.println("List is empty!");
        }
    }
    public static void findPersonByIndex(ArrayList<Personn> people){
        System.out.print("Enter an index --> ");
        int index = sc.nextInt();
        
        if(index < 0 || index >= people.size()){
            System.out.println("Invalid index : "+index);
        }else{
            // index is ok
            Personn p = people.get(index);
            System.out.println(p);
        }
    }
    public static void display(ArrayList<Personn> people){
        System.out.println(people);
    }
    
    public static int userChoice(){
        System.out.println("People register. ");
        System.out.println("1. Add");
        System.out.println("2. Update");
        System.out.println("3. Delete a person");
        System.out.println("4. Delete everyone");
        System.out.println("5. Find a person");
        System.out.println("6. Display");
        System.out.println("7. Exit");
        System.out.print("Enter choice --> ");
        return sc.nextInt();
    }
    
}

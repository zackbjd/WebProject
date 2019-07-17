package hdip.oop2.inheritance;

class Human{
    @Override
    public String toString(){
        return "Human";
    }
    public String whoAmI(){
        return "Human";
    }
}
class Male extends Human{
    @Override
    public String toString(){
        return "Male";
    }
    @Override
    public String whoAmI(){
        return "Male";
    }
    public String show(){
        return "I am a man";
    }
}
class Boy extends Male{}
class Man extends Male{
    @Override
    public String toString(){
        return "Man";
    }
}

class Female extends Human{
    @Override
    public String toString(){
        return "Female";
    }
    @Override
    public String whoAmI(){
        return "Female";
    }
}
class Girl extends Female{
    @Override
    public String toString(){
        return "Girl";
    }
}
class Woman extends Female{
    @Override
    public String toString(){
        return "Woman";
    }
}


public class PIE {
    public static void main(String[] args) {
        // 1.
//        Human h = new Human();
//        
//        System.out.println(h); // Human       
//        // 2.
//        h = new Male();
//        // 3.
//        System.out.println(h); // Male
//        // 4. 
//        h = new Female();
//        // 5.
//        System.out.println(h); // Female
//        // 6. 
//        h = new Boy();
//        // 7.
//        System.out.println(h.toString()); // Male
//        // 8.
//        //Male m = (Male)new Human();
//        //m.show(); // no show() in Human
//        
//        // version of 8 which runs ok
//        Human h1 = new Male();
//        Male m2  = (Male)h1;
//        // 9.
//        Boy b = new Boy();
//        System.out.println(b.show());// I am a man
        
        // 10.
        doSomething(new Human());
        doSomething(new Male());
        doSomething(new Female());
        doSomething(new Boy());
        doSomething(new Girl());
        doSomething(new Man());
        doSomething(new Woman());
    }
    public static void doSomething(Human h){
        System.out.println(h.whoAmI());
    }
}

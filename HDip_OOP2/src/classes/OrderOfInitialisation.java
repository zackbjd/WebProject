package classes;

class Tag{
    Tag(int marker){
        System.out.println("Tag("+marker+")");
    }
}

class Card extends Object{
    private int x;
    
    Tag t1 = new Tag(1);
//    for(int i=1; i<4; i++){
//    
//    }
    Card(){ // the no-arg constructor
        System.out.println("Card()");
        t3 = new Tag(33);
//        z++;
        int z=5;
        y++;

    }
    Tag t2 = new Tag(2);
    void f(){
        System.out.println("f()");
    }
    Tag t3 = new Tag(3);
    int xx = 5;
    private int y; // instance var
}

public class OrderOfInitialisation {
    public static void main(String[] args) {
        //new Tag(41);
        Card c = new Card(); // build the house
        c.f();  // open the door
//        cardObjectReference.y=3;
    }
    
}
/*
Tag(1)
Tag(2)
Tag(3)
Card()
Tag(33)
f()
*/
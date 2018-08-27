package person;

import static person.HairColor.*;

public class Person {
    HairColor hairColor = BLONDE;
    
    public Person()
    {
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Person Peter = new Person();
        Person SpiderMan = Peter;
        
        SpiderMan.hairColor = BLACK;
        
        System.out.println("Hair color of Peter is: "+ Peter.hairColor);
        System.out.println("Hair color of Spiderman is: "+ SpiderMan.hairColor);
    }
    
}

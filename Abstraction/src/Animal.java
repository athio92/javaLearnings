/**
 * Created by eclipze on 11/26/2016.
 */
public abstract class Animal {

    private String name;

    //constructor and getter
    public Animal (String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }


    //abstract methods
    public abstract void eat();
    public abstract void breathe();



}

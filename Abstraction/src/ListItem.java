/**
 * Created by eclipze on 11/26/2016.
 */

//Abstract class with three fields: an Object, and right+left instance of the same class
public abstract class ListItem {

    //Object = parent of all Class in Java.
    //The variable 'value' here means it can be any possible Object in Java.
    protected Object value;
    protected ListItem rightLink = null;
    protected ListItem leftLink = null;

    //constructor
    public ListItem(Object value) {
        this.value = value;
    }

    //getter
    public Object getValue() {
        return value;
    }

    //setter
    public void setValue(Object value) {
        this.value = value;
    }

    //abstract methods to navigate and change the list
    abstract ListItem next();

    abstract ListItem previous();

    abstract ListItem setNext(ListItem item);

    abstract ListItem setPrevious(ListItem item);

    abstract int compareTo(ListItem item);


}





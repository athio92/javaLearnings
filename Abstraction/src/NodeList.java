/**
 * Created by eclipze on 11/26/2016.
 */
public interface NodeList {

    ListItem getRoot();
    boolean addItem (ListItem item);
    boolean removeItem (ListItem item);
    void traverse(ListItem root);
}

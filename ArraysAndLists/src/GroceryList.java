import java.util.ArrayList;

/**
 * Created by eclipze on 11/15/2016.
 */
public class GroceryList {
    private ArrayList<String> groceryList = new ArrayList<String>();

    public void addGroceryItem(String item) {
        groceryList.add(item);
    }


    public void printGroceryList(){
        System.out.println("You have " + groceryList.size() + " items in your grocery list");
        for (int i=0; i<groceryList.size(); i++){
            System.out.println((i) + ". " + groceryList.get(i));
        }
    }

    public GroceryList(ArrayList<String> groceryList) {
        this.groceryList = groceryList;
    }

    public void modifyGroceryItem(int position, String newItem){
        groceryList.set(position, newItem);
        System.out.println("Grocery item " + position + "has been modified.");
    }

    public void removeGroceryItem(int position){
        String theItem = groceryList.get(position);
        groceryList.remove(position);
        System.out.println("Removed "+ theItem + "from the list.");
    }

    public String findItem(String searchItem){
        //boolean exists = groceryList.contains(searchItem);

        int position = groceryList.indexOf(searchItem);
        if (position>=0){
            return groceryList.get(position);
        }

        return null;
    }
}

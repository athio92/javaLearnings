import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by eclipze on 11/20/2016.
 */
public class Demo {
    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<String>();
        placesToVisit.add("Sydney");
        placesToVisit.add("Melbourne");
        placesToVisit.add("Brisbane");
        placesToVisit.add("Perth");
        placesToVisit.add("Canberra");
        placesToVisit.add("Adelaide");
        placesToVisit.add("Darwin");
        printList(placesToVisit);
        placesToVisit.add(1, "Alice Springs");
        placesToVisit.remove(4);
        printList(placesToVisit);
    }

    private static void printList(LinkedList<String> linkedList) {
        Iterator<String> i = linkedList.iterator();
        while (i.hasNext()) {
            System.out.println("Now visiting " + i.next());
            //note: i.next() returns current value the iterator is on, and then moves position to next value
        }
        System.out.println("===================");

    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newCity) {
        ListIterator<String> stringListIterator = linkedList.listIterator();
        while (stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newCity);
            //0 = match.
            if (comparison == 0) {
                //equal match, do not add
                System.out.println(newCity + " is already included as a destination");
                return false;

            } else if (comparison > 0) {
                //new City should apprear before this one
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            } else if (comparison < 0) {
                //nothing to do.
            }
        }
        stringListIterator.add(newCity);
    }

}

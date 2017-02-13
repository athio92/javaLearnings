import java.util.ArrayList;

/**
 * Created by eclipze on 11/17/2016.
 */
public class MobilePhone {

    private ArrayList<Contact> contactList = new ArrayList<Contact>();

    public void addContact(Contact contactObject){
        contactList.add(contactObject);
    }

    public void printContactList(){
        System.out.println("You have " + contactList.size() + " contacts.");
        for (int i=0; i<contactList.size(); i++){
            Contact contact = contactList.get(i);
            System.out.println((i) + ". " + contact.getName() + " " + contact.getPhoneNumber());
        }
    }


    public Contact searchContact(String searchName){

        for (int i=0; i<contactList.size(); i++){
            Contact contact = contactList.get(i);
            String contactName = contact.getName();

            if (contactName.equals(searchName)) {
                //returns contact object if name exist.
                System.out.println("Contact found.");
                return contact;
            }
            //else do nothing
       }

        System.out.println("There is no contact with that name.");
        return null;


    }

    public void modifyContact (String originalName, String newName, String newNumber){

        Contact targetContact = searchContact(originalName);
        targetContact.setName(newName);
        targetContact.setPhoneNumber(newNumber);
    }

/*
    public void removeContact{


    }
*/



}

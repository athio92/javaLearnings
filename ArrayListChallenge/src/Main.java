import java.util.Scanner;

/**
 * Created by eclipze on 11/17/2016.
 */
public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args) {
        //Program to implement a simple mobile phone that can store, modify, remove, and query contact names.
        // Create 2 class: Contacts (name and phone number) and MobilePhone (holds ArrayList of Contacts)
        //MobilePhone class has the functionality listed above.
        //Add a menu of options: Quit, print list of contacts, add new contact, update existing contact,
        // remove contact, Search/find contact
        // When adding/updating, be sure to check if the contact already exists (use name).
        //Do not expose the inner workings of the ArrayList to MobilePhone (no ints, no .get(i) etc)
        //MobilePhone should do everything with Contact objects only.
        addContacts();
        addContacts();
        printContacts();
        modifyContact();
        printContacts();


    }

    public static void addContacts() {
        System.out.println("Please enter Name: ");
        String name = scanner.nextLine();
        System.out.println("Please enter Phone Number: ");
        String phoneNumber = scanner.nextLine();
        //create Contact class
        Contact contact = new Contact(name, phoneNumber);
        mobilePhone.addContact(contact);
    }

    public static void printContacts() {
        mobilePhone.printContactList();
    }

    public static Contact findContact() {
        System.out.println("Please enter name of contact you'd like to search: ");
        String searchName = scanner.nextLine();
        Contact contactResult = mobilePhone.searchContact(searchName);
        return contactResult;
    }

    public static void modifyContact() {
        System.out.println("Please enter name of Contact you'd like to modify: ");
        String searchName = scanner.nextLine();
        System.out.println("Please enter new name: ");
        String newName = scanner.nextLine();
        System.out.println("Please enter new phone number: ");
        String newPhoneNumber = scanner.nextLine();

        mobilePhone.modifyContact(searchName,newName,newPhoneNumber);

    }

    public static void removeContacts() {
        System.out.println("");



    }



    public static void quitProgram() {
    }

    public static void printInstructions() {
    }
}
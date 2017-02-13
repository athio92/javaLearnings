import java.util.Scanner;

/**
 * Created by eclipze on 11/24/2016.
 */
public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Button btnPrint = new Button("Print");

    public static void main(String[] args) {
        //4 types of Inner Classes:
        //1. Static Nested Classes (used to associate a class with its outer class.
        // Same behavior as top-level class, but it is packaged in its outer class rather than in the package.
        // This means it cannot access the nonstatic methods or members of its outer class without first creating
        // an instance of that class)
        //2. Non-static Nested Classes
        //3. Local class (inner class defined inside of a scope block (usually a method))
        //4. Anonymous class (nested class without a class name)
//        Gearbox mcLaren = new Gearbox(6);
//        mcLaren.operateClutch(true);
//        mcLaren.changeGear(1);
//        mcLaren.operateClutch(false);
//        System.out.println(mcLaren.wheelSpeed(1000));
//        mcLaren.changeGear(2);
//        System.out.println(mcLaren.wheelSpeed(3000));
//        mcLaren.operateClutch(true);
//        mcLaren.changeGear(3);
//        mcLaren.operateClutch(false);
//        System.out.println(mcLaren.wheelSpeed(6000));
        class ClickListener implements Button.OnClickListener {
            public ClickListener() {
                System.out.println("I've been attached.");

            }

            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked.");

            }
        }
        btnPrint.setOnClickListener(new ClickListener());
        listen();

    }

    private static void listen() {
        boolean quit = false;
        while (!quit) {
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    btnPrint.onClick();

            }
        }

    }

}

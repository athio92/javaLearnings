import java.util.ArrayList;

/**
 * Created by eclipze on 11/24/2016.
 */

//Gearbox = class containing Arraylist of gears. Gear is a different class.
public class Gearbox {
    private ArrayList<Gear> gears;
    private int maxGears;
    private int currentGear = 0;
    private boolean clutchIsIn;
    //private int gearNumber = 0;

    public Gearbox (int maxGears){
        this.maxGears=maxGears;
        this.gears = new ArrayList<Gear>();
//        Gear neutral = new Gear(0, 0.0);
//        this.gears.add(neutral);

        for (int i=0; i<maxGears; i++){
            addGear(i, i*5.3);

        }

    }

    public void operateClutch(boolean in){
        this.clutchIsIn = in;
    }

    public void addGear (int number, double ratio){
        if ((number>0) && (number<= maxGears)){
            this.gears.add(new Gear(number,ratio));

        }
    }

    public void changeGear (int newGear){
        if((newGear>=0) && (newGear<this.gears.size())&& this.clutchIsIn ){
            this.currentGear = newGear;
            System.out.println("Gear "+newGear+" selected.");

        }else{
            System.out.println("Grind!");
        }

    }

    public double wheelSpeed(int revs){
        if(clutchIsIn){
            System.out.println("Scream!");
            return 0.0;
        }
        return revs * gears.get(currentGear).getRatio();
    }

    //Inner class Gear.  Instances of the Gear class has access
    //to all private (and public) methods or fields of the outer Gearbox class.
    //The keyword "This" inside Gear class refers to fields of Gear class, not Gearbox.
    private class Gear{
        private int gearNumber;
        private double ratio;

        public Gear(int gearNumber, double ratio) {
            //this.gearNumber refers to gear class, not gearbox.
            //To refer to Gearbox' gearNumber, use Gearbox.this.gearNumber.
            //(we changed Gearbox' gearNumber to currentGear to prevent code confusion).

            this.gearNumber = gearNumber;
            this.ratio = ratio;
        }

        public double getRatio() {
            return ratio;
        }

        public double driveSpeed(int revs){
            return revs * (this.ratio);
        }

    }


}

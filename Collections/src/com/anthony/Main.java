package com.anthony;

public class Main {

    public static void main(String[] args) {

        Theatre theatre = new Theatre("Olympian", 8, 12);
        theatre.getSeats();

        if(theatre.reserveSeat("H11")){
            System.out.println("Please pay fee");
        }else{
            System.out.println("Sorry, seat is taken");
        }
	// write your code here
    }
}

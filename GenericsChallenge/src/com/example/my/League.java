package com.example.my;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by eclipze on 12/2/2016.
 */
public class League<T extends Team>{
    public String name;
    private List<T> league = new ArrayList<T>();

    public League(String name) {
        this.name = name;
    }

    public boolean add(T team){
        if (league.contains(team)){
            System.out.println("com.example.my.Team is already inside teams list.");
            return false;
        } else {
            league.add(team);
            System.out.println("Added team" + team.getName() + " into teams list.");
            return true;
        }

    }

    public void showLeagueTable(){
        //sorting
        Collections.sort(league);

        //printing out
        for (T team: league){
            System.out.println(team.getName() + ": " + team.ranking());
        }
    }


}

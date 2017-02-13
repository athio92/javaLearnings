//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company;

import com.example.my.*;

public class Main {
    public static void main(String[] args) {
        League footballLeague = new League("AFL");
        Team adelaideCrows = new Team("Adelaide Crows");
        Team melbourne = new Team("Melbourne");
        Team hawthorn = new Team("Hawthorn");
        Team fremantle = new Team("Fremantle");
        new Team("Chicago Cubs");
        footballLeague.add(adelaideCrows);
        footballLeague.add(hawthorn);
        footballLeague.add(fremantle);
        footballLeague.add(melbourne);
        hawthorn.matchResult(fremantle, 1, 0);
        hawthorn.matchResult(adelaideCrows, 3, 8);
        adelaideCrows.matchResult(fremantle, 2, 1);
        footballLeague.showLeagueTable();
    }
}

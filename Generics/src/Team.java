import java.util.ArrayList;
import java.util.List;

/**
 * Created by eclipze on 11/29/2016.
 */
public class Team<T extends Player> implements Comparable<Team <T>> {
    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;

    private List<T> members = new ArrayList<>();

    @Override
    public int compareTo(Team<T> team) {
        if(this.ranking()>team.ranking()){
            return -1;

        }else if (this.ranking()< team.ranking()){
            return 1;
        }
        return 0;
    }

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T player){
        if (members.contains(player)){
            System.out.println(player.getName() + " is already inside members list");
            return false;
        } else {
            members.add(player);
            System.out.println(player.getName() + " picked for team " + this.name);
            return true;

        }
    }

    public int numPlayers(){
        return this.members.size();
    }

    public void matchResult (Team<T> opponent, int ourScore, int theirScore){
        if(ourScore>theirScore){
            won++;
        }else if (ourScore == theirScore){
            tied++;

        }else {
            lost++;
        }
        //increase number of games played
        played++;
        if (opponent != null){
            opponent.matchResult(null, theirScore, ourScore);
        }

    }

    public int ranking(){
        return (won*2) + tied;
    }


    public void printScore(){
        System.out.println("Team "+ name + " : played = " + played + ", won = " + won + ", tied = " + tied +
        ", lost = " + lost);

    }



}

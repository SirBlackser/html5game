package be.imaginelab.MuchkinQuest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arthu on 21/03/2017.
 */
public class MunchkinQuest {

    public static void main(String args[]){
        new MunchkinQuest();
    }

    public int numPlayers = 1;
    Player[] players;

    List<DXM> dxms = new ArrayList<DXM>();
    List<Treasure> treasures = new ArrayList<Treasure>();

    public void init(){
        //Initialize start board
        //Spawn random DXM deck
        //Spawn random Treasure deck
        //Spawn random Monster deck

        //init players
        //TODO GIVE PLAYER RANDOM CARDS + color
        for(int i = 0; i < numPlayers; i++){
            players[i]= new Player(COLOR.RED, dxms, treasures);
        }


    }
}

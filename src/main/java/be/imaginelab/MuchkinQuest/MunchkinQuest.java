package be.imaginelab.MuchkinQuest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by arthu on 21/03/2017.
 */
public class MunchkinQuest {

    public static void main(String args[]){
        new MunchkinQuest();
    }

    public int numPlayers = 2;
    Player[] players;

    List<DXM> dxms = new ArrayList<DXM>();
    List<Treasure> treasures = new ArrayList<Treasure>();

    MQMap MQMap = new MQMap(this);

    public void init(int numPlayers){

        //TODO Initialize start board
        //TODO Spawn random DXM deck
        //TODO Spawn random Treasure deck
        //TODO Spawn random Monster deck

        this.numPlayers = numPlayers;
        players = new Player[numPlayers];
        //init players
        Colors colors = new Colors();
        for(int i = 0; i < numPlayers; i++){
            players[i] = new Player(colors.getNext(), this);
        }

        //TODO roll for turn order

        //TODO all players may play races, classes and items to set up their character

        //TODO Start game

    }

    public MQMap getMQMap(){
        return MQMap;
    }

    public List<DXM> getDXM(int number){
        List<DXM> chosen = new ArrayList<>();
        Random random = new Random(System.currentTimeMillis());
        for(int i = 0; i < number; i++){
            int c = random.nextInt(dxms.size());
            chosen.add(dxms.get(c));
            dxms.remove(c);
        }
        return chosen;
    }

    public List<Treasure> getTreasure(int number){
        List<Treasure> chosen = new ArrayList<>();
        Random random = new Random(System.currentTimeMillis());
        for(int i = 0; i < number; i++){
            int c = random.nextInt(dxms.size());
            chosen.add(treasures.get(c));
            dxms.remove(c);
        }
        return chosen;
    }
}

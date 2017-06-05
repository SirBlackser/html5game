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

    public int numPlayers = 1;
    Player[] players;

    List<DXM> dxms = new ArrayList<DXM>();
    List<Treasure> treasures = new ArrayList<Treasure>();

    MQMap MQMap = new MQMap(this);

    public void init(){
        //Initialize start board
        //Spawn random DXM deck
        //Spawn random Treasure deck
        //Spawn random Monster deck

        //init players
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

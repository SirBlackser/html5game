package be.imaginelab.MuchkinQuest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arthu on 21/03/2017.
 */
public class Player {
    private MunchkinQuest munchkinQuest;

    public Colors.COLOR color = Colors.COLOR.RED;

    public int maxHealth = 4;
    public int health = 4;
    public int moves = 3;
    public int gold = 300;
    public int level = 1;

    public List<DXM> dxms;
    public List<Treasure> treasures;
    public List<Monster> monsters = new ArrayList<>();

    public Race.RACE race;
    public List<Class.CLASS> classes = new ArrayList<>();

    /*
    *Init player with color, 3 DXM and 3 treasure
     */
    public Player(Colors.COLOR color, MunchkinQuest munchkinQuest){
        this.munchkinQuest=munchkinQuest;
        this.color = color;
        this.dxms.addAll(dxms);
        this.treasures.addAll(treasures);

        race = Race.RACE.HUMAN;
    }

    public void startTurn(){
        //if dead
        if(health==0){
            munchkinQuest.getMQMap().setPlayerOnStartTile(this);
            health=maxHealth;
            gold=300;
            dxms.addAll(munchkinQuest.getDXM(2));
            treasures.addAll(munchkinQuest.getTreasure(2));
        }

        //start turn
        //draw dxm
        dxms.addAll(munchkinQuest.getDXM(1));

        //Monster on current tile?
        if(munchkinQuest.getMQMap().monsterOnPlayerTile(this)){
            //TODO COMBAT
            //Offer help/ receive help (number of treasures)

        }else{
            //TODO MOVEMENT

        }
    }

    public int getNumMonstersOwned(){
        return monsters.size();
    }
}

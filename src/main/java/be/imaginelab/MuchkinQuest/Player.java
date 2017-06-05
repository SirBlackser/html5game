package be.imaginelab.MuchkinQuest;

import java.util.List;

/**
 * Created by arthu on 21/03/2017.
 */
public class Player {

    static enum COLOR{
        BLUE,
        RED,
        GREEN,
        YELLOW
    }

    private MunchkinQuest munchkinQuest;

    public COLOR color = COLOR.RED;

    public int maxHealth = 3;
    public int health = 3;
    public int moves = 3;
    public int gold = 300;
    public int level = 1;

    public List<DXM> dxms;
    public List<Treasure> treasures;

    /*
    *Init player with color, 3 DXM and 3 treasure
     */
    public Player(COLOR color, MunchkinQuest munchkinQuest){
        this.munchkinQuest=munchkinQuest;
        this.color = color;
        this.dxms.addAll(dxms);
        this.treasures.addAll(treasures);
    }

    public void turn(){
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
        }else{

        }
    }
}

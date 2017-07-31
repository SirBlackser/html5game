package be.imaginelab.MuchkinQuest;

import be.imaginelab.MuchkinQuest.DXMs.DXM;
import be.imaginelab.MuchkinQuest.MapTiles.Effects;
import be.imaginelab.MuchkinQuest.MapTiles.MapTile;

import java.util.ArrayList;
import java.util.List;

import static be.imaginelab.MuchkinQuest.MapTiles.Effects.EFFECTS.FLIGHT;

/**
 * Created by arthu on 21/03/2017.
 */
public class Player {

    public enum CLASS{
        WARRIOR,
        PALADIN
    }

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
    public List<Player.CLASS> classes = new ArrayList<>();

    public List<Effects.EFFECTS> effects = new ArrayList<>();

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
            if(!(this.effects.contains(Effects.EFFECTS.IGNORE))){
                //TODO Monster ignores player?
                //Player still wants to combat?
                //TODO popup to override combat (should start new function)?
            }else{
                //No combat
            }
            //Offer help/ receive help (number of treasures)

        }else{
            //TODO Everybody may play any non combat card here

            //At entrance at level 10?
            if(munchkinQuest.getMQMap().playerLocations.get(this).equals(munchkinQuest.getMQStartTile()) && level == 10){
                //At entrance at level 10
                //TODO Boss fight
            }else{
                //Player actions
            }


        }
    }

    public boolean canPlayerMove(MapTile.DIRECTION direction){
        MapTile current = munchkinQuest.getMQMap().playerLocations.get(this);
        Door.DOORTYPE doortype = current.doors[direction.ordinal()].type;
        switch (doortype){
            case NORMAL:
                return (moves >= 1);
            case JUNKY:
                if(effects.contains(FLIGHT)) {
                    return (moves >= 1);
                }else
                    return (moves >=2);
            case WALL: return false;
            case LOCKED: return (moves >=3);
            case HIDDEN: return (moves >=3);
            default: return true;
        }
    }

    public void playerMove(MapTile.DIRECTION direction){
        if(canPlayerMove(direction)){
            //if tile does not yet exist -> create
            if(munchkinQuest.getMQMap().playerLocations.get(this).mapTiles[direction.ordinal()] == null){
                munchkinQuest.getMQMap().addTile(munchkinQuest.getMQMap().playerLocations.get(this), direction);
            }

            //then move in direction
            munchkinQuest.getMQMap().playerLocations.put(this, munchkinQuest.getMQMap().map.get(munchkinQuest.getMQMap().map.indexOf(munchkinQuest.getMQMap().playerLocations.get(this).mapTiles[direction.ordinal()])));


        }
    }

    //Player actions
    //TODO exit room
    //TODO search
    //TODO pick up
    //TODO make deal
    //TODO sell
    //TODO die
    //TODO End turn

    public int getNumMonstersOwned(){
        return monsters.size();
    }
}

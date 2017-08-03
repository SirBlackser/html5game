package be.imaginelab.MuchkinQuest;

import be.imaginelab.MuchkinQuest.DXMs.Classes.Class;
import be.imaginelab.MuchkinQuest.DXMs.Curses.Curse;
import be.imaginelab.MuchkinQuest.DXMs.DXM;
import be.imaginelab.MuchkinQuest.MapTiles.MapTile;
import be.imaginelab.MuchkinQuest.Treasures.Armor;
import be.imaginelab.MuchkinQuest.Treasures.Equipment;
import be.imaginelab.MuchkinQuest.Treasures.Treasure;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import static be.imaginelab.MuchkinQuest.EFFECTS.FLIGHT;
import static be.imaginelab.MuchkinQuest.MunchkinQuest.isDebug;
import static be.imaginelab.MuchkinQuest.Player.SEX.FEMALE;
import static be.imaginelab.MuchkinQuest.Player.SEX.MALE;

/**
 * Created by arthu on 21/03/2017.
 */
public class Player {

    public enum SEX{
        MALE,
        FEMALE
    }

    public MunchkinQuest munchkinQuest;

    public boolean isActive = false;

    public Colors.COLOR color = Colors.COLOR.RED;

    public int maxHealth = 4;
    public int health = 4;
    public int moves = 3;
    public int gold = 300;
    public int level = 1;

    public SEX sex = MALE;

    public List<DXM> dxms;
    public List<Treasure> treasures;
    public List<Equipment> equipment;
    public List<Monster> monsters = new ArrayList<>();

    public Race.RACE race;
    public List<Class> classes = new ArrayList<>();

    public List<Curse> curses = new ArrayList<>();
    public List<EFFECTS> effects = new ArrayList<>();

    public int numberOfHands = 2;

    public boolean pickupGold = true;
    public boolean pickupItems = true;

    public boolean isInCombat = false;
    public List<Object> discardAfterCombat = new ArrayList<>();

    /*
    *Init player with color, 3 DXM and 3 treasure
     */
    public Player(Colors.COLOR color, MunchkinQuest munchkinQuest, List<DXM> dxms, List<Treasure> treasures){
        this.munchkinQuest=munchkinQuest;
        this.color = color;
        this.dxms = dxms;
        this.treasures = treasures;

        race = Race.RACE.HUMAN;
    }

    public void startTurn(){
        //if dead
        if(health<=0){
            munchkinQuest.getMQMap().setPlayerOnStartTile(this);
            health=maxHealth;
            gold=300;
            dxms.addAll(munchkinQuest.getDXM(2));
            treasures.addAll(munchkinQuest.getTreasure(2));
        }

        pickupGold = true;
        pickupItems = true;

        //start turn
        //draw dxm
        List<DXM> draw = munchkinQuest.getDXM(1);
        dxms.addAll(draw);
        if(isDebug){
            System.out.println("Card(s) drawn:");
            for(DXM d : draw){
                System.out.println("\t" + d.name);
            }
        }

        //Monster on current tile?
        if(munchkinQuest.getMQMap().monsterOnPlayerTile(this)){
            if(!(this.effects.contains(EFFECTS.IGNORE))){
                //TODO Monster ignores player?
                //Player still wants to combat?
                //TODO popup to override combat (should start new function)?
                //Offer help/ receive help (number of treasures)

                //Discard some items after combat
                discardAfterCombat();
            }else{
                //No combat
            }
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

    public void onMonsterKill(){
        curses.forEach(curse -> onMonsterKill());
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
            if(munchkinQuest.getMQMap().playerLocations.get(this).neighbours[direction.ordinal()] == null){
                munchkinQuest.getMQMap().addTile(munchkinQuest.getMQMap().playerLocations.get(this), direction);
            }

            //then move in direction
            munchkinQuest.getMQMap().playerLocations.put(this, munchkinQuest.getMQMap().map.get(munchkinQuest.getMQMap().map.indexOf(munchkinQuest.getMQMap().playerLocations.get(this).neighbours[direction.ordinal()])));


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

    public void modifyHealth(int i) {
        health += i;
        if(health > maxHealth)
            health = maxHealth;
        if(health < 0)
            health = 0;
    }

    public void levelUp(){
        level++;
    }

    public void discardArmor(){
        ListIterator<Equipment> listIterator = equipment.listIterator();
        while(listIterator.hasNext()){
            Equipment e = listIterator.next();
            //TODO is headgear armor?
            if(e.getClass().equals(Armor.class)){
                listIterator.remove();
            }
        }
    }

    public void discardItem(Treasure treasure){
        treasures.remove(treasure);
    }

    public void dropGold(){
        munchkinQuest.getMQMap().playerLocations.get(this).gold = gold;
        gold = 0;
    }

    public void dropPack(){
        munchkinQuest.getMQMap().playerLocations.get(this).treasures = treasures;
        treasures.clear();
    }

    public void discardAfterCombat(){
        for(Object o : discardAfterCombat) {
            if (o.getClass() == Equipment.class) {
                equipment.remove(o);
            }
            if (o.getClass() == Curse.class) {
                curses.remove(o);
            }
        }
        discardAfterCombat.clear();
    }

    public void swapSex(){
        switch (sex){
            case MALE: sex = FEMALE;
                break;
            case FEMALE: sex = MALE;
                break;
        }
    }

    public void endTurn(){
        if(this.isActive){
            munchkinQuest.nextPlayer();
        }
    }

    public void runAway(){
        //TODO
    }

    public void move(){
        //Let the munchkin choose a room to move to without paying its cost
        //TODO movement
    }
}

package be.imaginelab.MuchkinQuest.DXMs.Classes;

import be.imaginelab.MuchkinQuest.DXMs.Curses.Curse;
import be.imaginelab.MuchkinQuest.DXMs.DXM;
import be.imaginelab.MuchkinQuest.MunchkinQuest;
import be.imaginelab.MuchkinQuest.Player;

import java.util.Random;

/**
 * Created by Arthur on 01/08/2017.
 */
public abstract class Class extends DXM {

    public enum CLASSES{
        NORMAL,
        WARRIOR,
        CLERIC,
        WIZARD,
        PALADIN
    }

    public boolean canD10 = true;

    Player player = null;

    public Class(MunchkinQuest munchkinQuest){
        super(munchkinQuest);

    }

    public void use(Object o){
        Player player = ((Player) o);
        player.classes.add(this);
        this.player = player;
    }

    public void onTurnChange(){
        canD10 = true;
    }

    protected boolean tryD10(){
        //TODO extra D10 rolls
        int extras = 0;
        return (new Random().nextInt(10)+extras >= 10);
    }

    public abstract void rollD10(Player receiver);
    public void onCurse(Player owner, Curse curse){
        return;
    }
    public abstract void specialSkill(Player owner, Player receiver);
}

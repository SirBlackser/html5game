package be.imaginelab.MuchkinQuest.DXMs.Curses;

import be.imaginelab.MuchkinQuest.DXMs.DXM;
import be.imaginelab.MuchkinQuest.MunchkinQuest;
import be.imaginelab.MuchkinQuest.Player;

/**
 * Created by Arthur on 01/08/2017.
 */
public abstract class Curse extends DXM {

    Player player;

    public Curse(MunchkinQuest munchkinQuest){
        super(munchkinQuest);
        mainText = "CURSE!";
    }

    public abstract void use(Object o);
    public void onMonsterKill(Object o){};
    public void onTurnStart(Object o){};
    public int getModifiedMoves(Object o){return 0;};

    public void remove(){
        player.curses.remove(this);
    }
}

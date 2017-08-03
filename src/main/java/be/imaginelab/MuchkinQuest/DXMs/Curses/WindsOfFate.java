package be.imaginelab.MuchkinQuest.DXMs.Curses;

import be.imaginelab.MuchkinQuest.MunchkinQuest;
import be.imaginelab.MuchkinQuest.Player;

/**
 * Created by Arthur on 02/08/2017.
 */
public class WindsOfFate extends Curse {
    public WindsOfFate(MunchkinQuest munchkinQuest) {
        super(munchkinQuest);
        name = "WINDS OF FATE!";
        description = "Play at any time. Move the victim one room in any direction except through a wall.\n Yes, this curse can be used to let any munchkin, including yourself, Run Away.";
    }

    @Override
    public void use(Object o) {
        Player player = (Player) o;
        if(player.isInCombat){
            player.runAway();
        }else{
            player.moveFree();
        }
    }
}

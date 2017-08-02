package be.imaginelab.MuchkinQuest.DXMs.Curses;

import be.imaginelab.MuchkinQuest.MunchkinQuest;
import be.imaginelab.MuchkinQuest.Player;

/**
 * Created by Arthur on 01/08/2017.
 */
public class ArmorTurnsToPudding extends Curse {
    public ArmorTurnsToPudding(MunchkinQuest munchkinQuest){
        super(munchkinQuest);

        name = "ARMOR TURN TO PUDDING!";
        description = "Play at any time. The victim discard the Armor he is wearing.";
    }

    @Override
    public void use(Object o) {
        Player player = (Player) o;
        player.discardArmor();
        //One time use, curse dissapears
    }
}

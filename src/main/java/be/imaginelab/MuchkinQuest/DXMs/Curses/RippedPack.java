package be.imaginelab.MuchkinQuest.DXMs.Curses;

import be.imaginelab.MuchkinQuest.MunchkinQuest;
import be.imaginelab.MuchkinQuest.Player;

/**
 * Created by Arthur on 01/08/2017.
 */
public class RippedPack extends Curse {
    public RippedPack(MunchkinQuest munchkinQuest) {
        super(munchkinQuest);
        name = "RIPPED PACK!";
        description = "Play at any time. The victim drops everything in his pack. If it is his turn, he may not pick anything up until his next turn.";
    }

    @Override
    public void use(Object o) {
        Player player = ((Player) o);
        player.dropPack();
        player.pickupItems = false;
    }
}

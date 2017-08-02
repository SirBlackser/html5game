package be.imaginelab.MuchkinQuest.DXMs.Curses;

import be.imaginelab.MuchkinQuest.MunchkinQuest;
import be.imaginelab.MuchkinQuest.Player;

/**
 * Created by Arthur on 01/08/2017.
 */
public class HoleInPocket extends Curse {
    public HoleInPocket(MunchkinQuest munchkinQuest) {
        super(munchkinQuest);
        name = "HOLE IN POCKET!";
        description = "Play at any time. The victim drops all his gold. He cannot pick it up until his next turn...if it's still there.";
    }

    @Override
    public void use(Object o) {
        Player player = ((Player) o);
        player.dropGold();
        player.pickupGold = false;
    }
}

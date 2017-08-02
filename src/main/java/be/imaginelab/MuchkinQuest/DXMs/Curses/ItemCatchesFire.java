package be.imaginelab.MuchkinQuest.DXMs.Curses;

import be.imaginelab.MuchkinQuest.MunchkinQuest;

/**
 * Created by Arthur on 01/08/2017.
 */
public class ItemCatchesFire extends Curse {
    public ItemCatchesFire(MunchkinQuest munchkinQuest) {
        super(munchkinQuest);
        name = "ITEM CATCHES FIRE!";
        description = "Play at any time. The victim discards an Item of your choice. This curse will not affect a munchkin who has protection from Flame";
    }

    @Override
    public void use(Object o) {
        //TODO implement
    }
}

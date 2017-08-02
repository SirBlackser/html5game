package be.imaginelab.MuchkinQuest.DXMs.Curses;

import be.imaginelab.MuchkinQuest.MunchkinQuest;
import be.imaginelab.MuchkinQuest.Player;

/**
 * Created by Arthur on 01/08/2017.
 */
public class WarrantyExpires extends Curse {
    public WarrantyExpires(MunchkinQuest munchkinQuest) {
        super(munchkinQuest);
        name = "WARRANTY EXPRES!";
        description = "Play at any time. The victim must discard a non-one-shot Item of his choice.";
    }

    @Override
    public void use(Object o) {
        Player player = (Player) o;
        //TODO let victim choose item to discard (popup)
    }
}

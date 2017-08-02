package be.imaginelab.MuchkinQuest.DXMs.Curses;

import be.imaginelab.MuchkinQuest.MunchkinQuest;
import be.imaginelab.MuchkinQuest.Player;

/**
 * Created by Arthur on 01/08/2017.
 */
public class ShoelacesTiedTogether extends Curse {
    public ShoelacesTiedTogether(MunchkinQuest munchkinQuest) {
        super(munchkinQuest);
        name = "SHOELACES TIED TOGETHER";
        description = "Play at any time. The victim loses one move token immediately, and does not get it back until the curse is removed. Keep this card as a reminder until the curse is removed; then discard it.";

    }

    @Override
    public void use(Object o) {

    }

    @Override
    public int getModifiedMoves(Object o) {
        return ((Player) o).moves-1;
    }
}

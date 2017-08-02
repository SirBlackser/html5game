package be.imaginelab.MuchkinQuest.DXMs.Curses;

import be.imaginelab.MuchkinQuest.MunchkinQuest;
import be.imaginelab.MuchkinQuest.Player;

/**
 * Created by Arthur on 01/08/2017.
 */
public class ChangeSex extends Curse{
    public ChangeSex(MunchkinQuest munchkinQuest) {
        super(munchkinQuest);
        name = "CHANGE SEX!";
        description = "Play at any time. The victim gets a -5 penalty on his next combat due to distraction. After that, there is no further penalty, but the change is permanent.\n Keep this card as a reminder until you have fought the combat with the -5 penalty; then discard it.";


    }

    @Override
    public void use(Object o) {
        Player player = ((Player) o);
        player.swapSex();
        player.curses.add(this);
        //curse lingers until after combat
    }

    @Override
    protected int getExtraLevel() {
        player.discardAfterCombat.add(this);
        return -5;
    }
}

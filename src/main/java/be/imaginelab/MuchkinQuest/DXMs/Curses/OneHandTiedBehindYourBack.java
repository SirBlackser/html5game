package be.imaginelab.MuchkinQuest.DXMs.Curses;

import be.imaginelab.MuchkinQuest.MunchkinQuest;
import be.imaginelab.MuchkinQuest.Player;

/**
 * Created by Arthur on 01/08/2017.
 */
public class OneHandTiedBehindYourBack extends Curse {
    public OneHandTiedBehindYourBack(MunchkinQuest munchkinQuest) {
        super(munchkinQuest);
        name = "ONE HAND TIED BEHIND YOUR BACK!";
        description = "Play at any time. The victim now has one fewer Hand. However, he gets an extra 200 gold pieces for every monster he kills, or helps to kill, with one hand tied behind his back!";
    }

    @Override
    public void use(Object o) {
        Player player = ((Player) o);
        player.numberOfHands--;
        player.curses.add(this);
    }

    @Override
    public void onMonsterKill(Object o) {
        Player player = (Player) o;
        player.gold += 200;
    }
}

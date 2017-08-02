package be.imaginelab.MuchkinQuest.DXMs.Curses.MonsterMovement;

import be.imaginelab.MuchkinQuest.DXMs.Curses.Curse;
import be.imaginelab.MuchkinQuest.MunchkinQuest;

/**
 * Created by Arthur on 01/08/2017.
 */
public class RulesChange extends Curse {
    public RulesChange(MunchkinQuest munchkinQuest) {
        super(munchkinQuest);
        name = "RULES CHANGE!";
        description = "Play at any time. The victim must discard an Item or Items of his choice, worth at least 500 gold pieces.";
    }

    @Override
    public void use(Object o) {
        //TODO Implement
    }
}

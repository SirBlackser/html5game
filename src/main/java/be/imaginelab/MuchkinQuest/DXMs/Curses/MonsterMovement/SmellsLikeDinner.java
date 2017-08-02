package be.imaginelab.MuchkinQuest.DXMs.Curses.MonsterMovement;

import be.imaginelab.MuchkinQuest.DXMs.Curses.Curse;
import be.imaginelab.MuchkinQuest.MunchkinQuest;

/**
 * Created by Arthur on 01/08/2017.
 */
public class SmellsLikeDinner extends Curse {
    public SmellsLikeDinner(MunchkinQuest munchkinQuest) {
        super(munchkinQuest);
        name = "SMELLS LIKE DINNER!";
        description = "Play at any time. All Huge monsters in the dungeon move one room toward the cursed munchkin, as long as they can do so legally. If two rooms are equally close, the player who cast the curse decides where the monster goeos.";
    }

    @Override
    public void use(Object o) {
        //TODO implement
    }
}

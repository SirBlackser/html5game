package be.imaginelab.MuchkinQuest.DXMs.MonsterModifiers;

import be.imaginelab.MuchkinQuest.EFFECTS;
import be.imaginelab.MuchkinQuest.Monster;
import be.imaginelab.MuchkinQuest.MunchkinQuest;

/**
 * Created by Arthur on 01/08/2017.
 */
public class Baby extends MonsterModifier{
    public Baby(MunchkinQuest munchkinQuest){
        super(munchkinQuest);
        name = "BABY";
        mainText = "-5 TO LEVEL OF MONSTER";
        description = "Play on any monster. Keep this card with the monster until it is defeated. \n The monster counts as one size smaller. If it was already Tiny, it gains the power to move through any door by running underneath. \n If the monster is defeated, draw one fewer Treasure (minimum 1).";

        extraLevel = -5;
        sizeChange = -1;
        extraTreasures = -1;
    }

    @Override
    protected void use(Object o) {
        ((Monster) o).modifiers.add(this);
    }


}

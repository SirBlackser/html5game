package be.imaginelab.MuchkinQuest.DXMs.MonsterModifiers;

import be.imaginelab.MuchkinQuest.DXMs.Classes.Class;
import be.imaginelab.MuchkinQuest.Monster;
import be.imaginelab.MuchkinQuest.MunchkinQuest;

import static be.imaginelab.MuchkinQuest.DXMs.Classes.Class.CLASSES.CLERIC;

/**
 * Created by Arthur on 02/08/2017.
 */
public class Demonic extends MonsterModifier {
    public Demonic(MunchkinQuest munchkinQuest) {
        super(munchkinQuest);
        name = "DEMONIC";
        mainText = "+5 TO LEVEL OF MONSTER (+10 AGAINST CLERICS)";
        description = "Play on any monster except a Demon. That monster becomes a Demon. Keep this card with the monster until it is defeated.\n If the monster is defeated, draw one extra Treasure";

        extraTreasures = 1;
    }

    @Override
    protected void use(Object o) {
        ((Monster) o).modifiers.add(this);
    }

    @Override
    public int getExtraLevel(Class.CLASSES type) {
        switch (type){
            case CLERIC:
                return 10;
            default:
                return 5;
        }
    }
}

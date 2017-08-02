package be.imaginelab.MuchkinQuest.DXMs.MonsterModifiers;

import be.imaginelab.MuchkinQuest.DXMs.Classes.Class;
import be.imaginelab.MuchkinQuest.DXMs.Classes.Class.CLASSES;
import be.imaginelab.MuchkinQuest.Monster;
import be.imaginelab.MuchkinQuest.MunchkinQuest;
import be.imaginelab.MuchkinQuest.Player;

import static be.imaginelab.MuchkinQuest.DXMs.Classes.Class.CLASSES.WARRIOR;

/**
 * Created by Arthur on 31/07/2017.
 */
public class Armored extends MonsterModifier {

    public Armored(MunchkinQuest munchkinQuest){
        super(munchkinQuest);
        name = "ARMORED";
        mainText = "=5 TO LEVEL OF MONSTER (+10 AGAINST WARRIORS)";
        description = "Play one any monster. Keep this card with the monster until it is defeated. \n If the monster is defeated, draw one extra Treasure.";

        this.extraTreasures = 1;
    }

    @Override
    protected void use(Object o) {
        ((Monster) o).modifiers.add(this);
    }

    @Override
    public int getExtraLevel(CLASSES type){
        switch (type){
            case WARRIOR:
                return 10;
            default:
                return 5;
        }
    }
}

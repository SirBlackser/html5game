package be.imaginelab.MuchkinQuest.DXMs.MonsterModifiers;

import be.imaginelab.MuchkinQuest.DXMs.Classes.Class;
import be.imaginelab.MuchkinQuest.Monster;
import be.imaginelab.MuchkinQuest.MunchkinQuest;

/**
 * Created by Arthur on 01/08/2017.
 */
public class ColdlyRational extends MonsterModifier {
    public ColdlyRational(MunchkinQuest munchkinQuest){
        super(munchkinQuest);
        name = "COLDLY RATIONAL";
        mainText = "+5 TO LEVEL OF MONSTER (+10 AGAINST WIZARDS)";
        description = "Play on any monster. Keep this card with the monster until it is defeated. \n No Magic items may be used in the monster's room, or used from any other room to affect anything in the monster's room, in combat or otherwise. A player in the monster's room gets no benefit from the Magic items he is carrying. \n If the monster is defeated, draw one extra Treasure.";

        extraTreasures = 1;
    }

    @Override
    protected void use(Object o) {
        ((Monster) o).modifiers.add(this);
    }

    @Override
    public int getExtraLevel(Class.CLASSES type) {
        switch (type){
            case WIZARD:
                return 10;
            default: return 5;
        }
    }

}

package be.imaginelab.MuchkinQuest.DXMs.MonsterModifiers;

import be.imaginelab.MuchkinQuest.DXMs.DXM;
import be.imaginelab.MuchkinQuest.Monster;
import be.imaginelab.MuchkinQuest.MunchkinQuest;

/**
 * Created by Arthur on 31/07/2017.
 */
public class Ancient extends MonsterModifier {

    public Ancient(MunchkinQuest munchkinQuest){
        super(munchkinQuest);
       name = "ANCIENT";
       mainText = "+10 TO LEVEL OF MONSTER";
       description = "Play on any monster. Keep this card with the monster until it is defeated. \n Munchkins now have +1 to Run Away from it. \n If the monster is defeated, draw two extra Treasures.";

       this.extraLevel =10;
       this.extraRunAway = 1;
       this.extraTreasures = 2;
    }

    @Override
    protected void use(Object o) {
        ((Monster) o).modifiers.add(this);
    }

}

package be.imaginelab.MuchkinQuest.DXMs.MonsterModifiers;

import be.imaginelab.MuchkinQuest.Monster;
import be.imaginelab.MuchkinQuest.Player;

/**
 * Created by Arthur on 31/07/2017.
 */
public class Armored extends MonsterModifier {

    public Armored(){
        this.extraTreasures = 1;
    }

    @Override
    public int getExtraLevel(Player.CLASS type){
        switch (type){
            case WARRIOR:
                return 10;
            default:
                return 5;
        }
    }
}

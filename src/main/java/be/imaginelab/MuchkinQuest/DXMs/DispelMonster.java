package be.imaginelab.MuchkinQuest.DXMs;

import be.imaginelab.MuchkinQuest.Monster;
import be.imaginelab.MuchkinQuest.MunchkinQuest;

/**
 * Created by Arthur on 02/08/2017.
 */
public class DispelMonster extends DXM {
    public DispelMonster(MunchkinQuest munchkinQuest) {
        super(munchkinQuest);
        name = "DISPEL MONSTER";
        description = "Play at any time. Discard a monster and any treasure it was carrying. If used in combat, this does not count as a kill and does not grant levels.";
    }

    @Override
    protected void use(Object o) {
        //TODO
    }
}

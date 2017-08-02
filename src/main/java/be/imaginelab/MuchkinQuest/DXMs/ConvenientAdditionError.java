package be.imaginelab.MuchkinQuest.DXMs;

import be.imaginelab.MuchkinQuest.MunchkinQuest;
import be.imaginelab.MuchkinQuest.Player;

/**
 * Created by Arthur on 01/08/2017.
 */
public class ConvenientAdditionError extends DXM {
    public ConvenientAdditionError(MunchkinQuest munchkinQuest){
        super(munchkinQuest);
        name = "CONVENIENT ADDITION ERROR";

    }

    @Override
    protected void use(Object o) {
        ((Player) o).levelUp();
    }
}

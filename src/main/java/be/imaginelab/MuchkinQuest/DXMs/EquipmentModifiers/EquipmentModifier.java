package be.imaginelab.MuchkinQuest.DXMs.EquipmentModifiers;

import be.imaginelab.MuchkinQuest.DXMs.DXM;
import be.imaginelab.MuchkinQuest.Treasures.Equipment;
import be.imaginelab.MuchkinQuest.MunchkinQuest;
import be.imaginelab.MuchkinQuest.Player;

import java.util.List;

/**
 * Created by Arthur on 01/08/2017.
 */
public abstract class EquipmentModifier extends DXM {

    public EquipmentModifier(MunchkinQuest munchkinQuest){
        super(munchkinQuest);
    }

    abstract public List<Equipment.EFFECTS> getAdvantages(Equipment equipment);
    abstract public List<Equipment.EFFECTS> getDisadvantages(Equipment equipment);
    abstract public boolean isEquipable(Player player);

    protected void use(Object o) {
        ((Equipment) o).modifiers.add(this);
    }
}

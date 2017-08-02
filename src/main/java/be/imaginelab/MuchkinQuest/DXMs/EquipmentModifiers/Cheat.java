package be.imaginelab.MuchkinQuest.DXMs.EquipmentModifiers;

import be.imaginelab.MuchkinQuest.Treasures.Equipment;
import be.imaginelab.MuchkinQuest.MunchkinQuest;
import be.imaginelab.MuchkinQuest.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arthur on 01/08/2017.
 */
public class Cheat extends EquipmentModifier {

    public Cheat(MunchkinQuest munchkinQuest){
        super(munchkinQuest);
        name = "CHEAT";
        description = "This card fulfills all requirements (hands, Race, Class, sex, location, possession of other items, etc.) on any one Item, letting you use the Item, or get its full bonus, when you should not be entitled to. You may also ignore all penalties for carrying that Item. You get all its advantages and none of its disadvantages. \n Put this card with that Item. Discard it when you lose that Item";
    }

    @Override
    public List<Equipment.EFFECTS> getAdvantages(Equipment equipment){
        return equipment.advantages;
    }

    @Override
    public List<Equipment.EFFECTS> getDisadvantages(Equipment equipment){
        return new ArrayList<>();
    }

    @Override
    public boolean isEquipable(Player player){
        return true;
    }

}

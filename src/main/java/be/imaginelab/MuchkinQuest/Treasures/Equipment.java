package be.imaginelab.MuchkinQuest.Treasures;

import be.imaginelab.MuchkinQuest.DXMs.EquipmentModifiers.EquipmentModifier;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arthu on 21/03/2017.
 */
public class Equipment extends Item {

    public enum EFFECTS{

    }

    public List<EquipmentModifier> modifiers = new ArrayList<>();

    public List<EFFECTS> advantages;
    public List<EFFECTS> disadvantages;

    public boolean equipable = false;
}

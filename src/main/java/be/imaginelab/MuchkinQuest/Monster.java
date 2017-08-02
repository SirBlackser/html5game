package be.imaginelab.MuchkinQuest;

import be.imaginelab.MuchkinQuest.DXMs.MonsterModifiers.MonsterModifier;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arthu on 21/03/2017.
 */
public class Monster {
    public enum SIZE{
        TINY,
        NORMAL,
        BIG
    }

    public SIZE size;

    public List<MonsterModifier> modifiers = new ArrayList<>();
    public List<EFFECTS> effects = new ArrayList<>();

    public Monster(){

    }
}

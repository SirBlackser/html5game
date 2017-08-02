package be.imaginelab.MuchkinQuest.DXMs.MonsterModifiers;

import be.imaginelab.MuchkinQuest.DXMs.Classes.Class;
import be.imaginelab.MuchkinQuest.DXMs.DXM;
import be.imaginelab.MuchkinQuest.EFFECTS;
import be.imaginelab.MuchkinQuest.Monster;
import be.imaginelab.MuchkinQuest.MunchkinQuest;
import be.imaginelab.MuchkinQuest.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Arthur on 31/07/2017.
 * A monster modifier is a class you add to a monster, the monster then calculates its stats based on all monsterModifiers present.
 */
public abstract class MonsterModifier extends DXM{

    protected int extraLevel = 0;
    protected int extraRunAway = 0;
    protected int extraTreasures = 0;
    protected int sizeChange = 0;

    public MonsterModifier(MunchkinQuest munchkinQuest){
        super(munchkinQuest);
    }

    public int getExtraLevel(Class.CLASSES type){
        return extraLevel;
    }
    public Monster.SIZE getSize(Monster monster){
        switch (monster.size){
            case TINY:
                switch (sizeChange) {
                    case -1 | -2:
                        monster.effects.add(EFFECTS.NODOORS);
                    default:
                        return Monster.SIZE.TINY;
                    case 1: return Monster.SIZE.NORMAL;
                    case 2: return Monster.SIZE.BIG;
                }
            case NORMAL:
                switch (sizeChange) {
                    case -2 | -1: return Monster.SIZE.TINY;
                    default: return Monster.SIZE.NORMAL;
                    case 1 | 2: return Monster.SIZE.BIG;
                }
            case BIG:
                switch (sizeChange) {
                    case -2: return Monster.SIZE.TINY;
                    case -1: return Monster.SIZE.NORMAL;
                    default: return Monster.SIZE.BIG;
                }
            default: return monster.size;
        }
    }
}

package be.imaginelab.MuchkinQuest.DXMs.MonsterModifiers;

import be.imaginelab.MuchkinQuest.DXMs.DXM;
import be.imaginelab.MuchkinQuest.MapTiles.Effects;
import be.imaginelab.MuchkinQuest.Monster;
import be.imaginelab.MuchkinQuest.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Arthur on 31/07/2017.
 */
public class MonsterModifier extends DXM{

    protected int extraLevel = 0;
    protected Map<Player.CLASS, Integer> bonuses = new HashMap<>();
    protected int extraRunAway = 0;
    protected int extraTreasures = 0;

    public int getExtraLevel(Player.CLASS type){
        return extraLevel;
    }

}

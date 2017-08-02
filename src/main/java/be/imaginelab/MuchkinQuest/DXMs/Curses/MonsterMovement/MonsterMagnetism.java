package be.imaginelab.MuchkinQuest.DXMs.Curses.MonsterMovement;

import be.imaginelab.MuchkinQuest.DXMs.Curses.Curse;
import be.imaginelab.MuchkinQuest.Monster;
import be.imaginelab.MuchkinQuest.MunchkinQuest;
import be.imaginelab.MuchkinQuest.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arthur on 01/08/2017.
 */
public class MonsterMagnetism extends Curse {
    public MonsterMagnetism(MunchkinQuest munchkinQuest) {
        super(munchkinQuest);
        name = "MONSTER MAGNETISM!";
        description = "Play at any time. All monsters withing three rooms of the cursed munchkin move one room toward him, as long as they can do so legally. If two rooms are equally close, the player wo cast the curse decides where the monster goes. \n this is not a continuing curse; its effects are instant but only occur once.";
    }

    @Override
    public void use(Object o) {
        Player player = (Player) o;
        List<Monster> monsters =  player.munchkinQuest.getMQMap().findMonstersCloseTo(player.munchkinQuest.getMQMap().playerLocations.get(this), 3);
        player.munchkinQuest.getMQMap().moveMonsterTowards(monsters, player.munchkinQuest.getMQMap().playerLocations.get(this));
    }
}

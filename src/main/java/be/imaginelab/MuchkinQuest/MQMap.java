package be.imaginelab.MuchkinQuest;

import be.imaginelab.MuchkinQuest.MapTiles.MapTile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by arthu on 5/06/2017.
 */
public class MQMap {

    List<MapTile> map = new ArrayList<>();
    Map<MapTile, List<Monster>> monsterMap = new HashMap<>();
    Map<Player, MapTile> playerLocations = new HashMap<>();

    private MunchkinQuest munchkinQuest;

    public MQMap(MunchkinQuest munchkinQuest){
        this.munchkinQuest=munchkinQuest;
    }

    public void setPlayerOnStartTile(Player player){
        playerLocations.put(player, map.get(0));
    }

    public boolean monsterOnPlayerTile(Player player){
        if(monsterMap.get(playerLocations.get(player)).size() > 0){
            return true;
        }else
            return false;
    }

}

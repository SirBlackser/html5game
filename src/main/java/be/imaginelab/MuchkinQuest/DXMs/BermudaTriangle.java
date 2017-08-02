package be.imaginelab.MuchkinQuest.DXMs;

import be.imaginelab.MuchkinQuest.MQMap;
import be.imaginelab.MuchkinQuest.MapTiles.MapTile;
import be.imaginelab.MuchkinQuest.MunchkinQuest;

/**
 * Created by Arthur on 01/08/2017.
 */
public class BermudaTriangle extends DXM{
    public BermudaTriangle(MunchkinQuest munchkinQuest){
        super(munchkinQuest);
        name = "BERMUDA TRIANGLE";
        description = "Play at any time. Remove a room that contains no munchkins. Leave its links in place. Discard any monsters or Items there, and put the room tile back in the box. It may be drawn again.";

    }

    public void use(Object o){
        MapTile tile = (MapTile) o;
        //If no player on tile
        if(!munchkinQuest.getMQMap().isAnyPlayerOnTile(tile)){
            munchkinQuest.getMQMap().monsterLocations.remove(tile);
            munchkinQuest.getMQMap().itemLocations.remove(tile);
            munchkinQuest.getMQMap().deck.add(tile);
        }
    }
}

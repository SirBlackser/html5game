package be.imaginelab.MuchkinQuest.MapTiles;

import be.imaginelab.MuchkinQuest.Class;

/**
 * Created by arthu on 30/05/2017.
 */
public class TileArmoury extends MapTile{
    @Override
    public void special() {

    }

    public TileArmoury(){
        this.bonuses.add(Class.CLASS.WARRIOR);
        this.bonuses.add(Class.CLASS.PALADIN);
    }
}

package be.imaginelab.MuchkinQuest.MapTiles;

/**
 * Created by arthu on 30/05/2017.
 */
public class TileStart extends MapTile{

    @Override
    public void special() {
        return;
    }

    public TileStart(){
        this.searchable=false;
        this.monstersEndHere=false;
    }
}

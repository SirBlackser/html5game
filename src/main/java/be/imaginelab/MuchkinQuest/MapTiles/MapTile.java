package be.imaginelab.MuchkinQuest.MapTiles;

import be.imaginelab.MuchkinQuest.DXMs.Classes.Class;
import be.imaginelab.MuchkinQuest.Door;
import be.imaginelab.MuchkinQuest.Player;
import be.imaginelab.MuchkinQuest.Treasures.Treasure;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arthu on 30/05/2017.
 */
abstract public class MapTile {

    public enum DIRECTION{
        UP, RIGHT, DOWN, LEFT
    }

    public DIRECTION getOppositeDir(DIRECTION dir){
        switch (dir){
            case UP: return DIRECTION.DOWN;
            case DOWN: return DIRECTION.UP;
            case LEFT: return DIRECTION.RIGHT;
            case RIGHT: return DIRECTION.LEFT;
            default: return DIRECTION.UP;
        }
    }

    //In order up, right, down, left
    public MapTile[] neighbours = new MapTile[4];
    public Door[] doors = new Door[4];
    public Location location;

    boolean searchable = true;
    boolean monstersEndHere = true;

    List<Class.CLASSES> bonuses = new ArrayList<>();
    List<Class.CLASSES> disadvantage = new ArrayList<>();

    public int gold = 0;
    public List<Treasure> treasures = new ArrayList<>();

    public List<Player> players = new ArrayList<Player>();

    public MapTile(){}

    @Override
    public boolean equals(Object o){
        if(o.getClass().equals(MapTile.class)){
            return (((MapTile) o).location.equals(this.location));
        }

        if(o.getClass().equals(Location.class)){
            return o.equals(this.location);
        }

        return false;
    }

    abstract public void special();
}

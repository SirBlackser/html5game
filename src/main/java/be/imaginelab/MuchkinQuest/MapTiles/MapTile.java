package be.imaginelab.MuchkinQuest.MapTiles;

import be.imaginelab.MuchkinQuest.Class;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arthu on 30/05/2017.
 */
abstract public class MapTile {
    public MapTile up, down, left, right;

    boolean searchable = true;
    boolean monstersEndHere = true;

    List<Class.CLASS> bonuses = new ArrayList<>();
    List<Class.CLASS> disadvantage = new ArrayList<>();

    public MapTile(){}

    abstract public void special();
}

package be.imaginelab.MuchkinQuest;

import be.imaginelab.MuchkinQuest.MapTiles.Location;
import be.imaginelab.MuchkinQuest.MapTiles.MapTile;
import be.imaginelab.MuchkinQuest.MapTiles.TileArmoury;
import be.imaginelab.MuchkinQuest.MapTiles.TileStart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by arthu on 5/06/2017.
 */
public class MQMap {

    //All remaining cards in the deck
    List<MapTile> deck = new ArrayList<>();

    MapTile startTile = new TileStart();
    List<MapTile> map = new ArrayList<>();
    Map<MapTile, List<Monster>> monsterMap = new HashMap<>();
    Map<Player, MapTile> playerLocations = new HashMap<>();

    private MunchkinQuest munchkinQuest;

    public MQMap(MunchkinQuest munchkinQuest){
        this.munchkinQuest=munchkinQuest;
        addStartTile();
    }

    public void addStartTile(){
        //generate doors
        startTile.doors = new Door[]{new Door(), new Door(), new Door(), new Door()};
        map.add(startTile);
    }

    public void addTile(MapTile current, MapTile.DIRECTION direction){
        //Todo get map from deck
        //mock Tile
        MapTile tile = new TileArmoury();

        addTile(current, direction, tile);
    }

    public void addTile(MapTile current, MapTile.DIRECTION direction, MapTile newTile){
        Door[] newDoors = new Door[4];

        //Determine new tile's location
        Location newTileLocation;
        switch (direction){
            case UP: newTileLocation = new Location(current.location.location[0], current.location.location[1]-1);
            break;
            case RIGHT: newTileLocation = new Location(current.location.location[0]+1, current.location.location[1]);
            break;
            case DOWN: newTileLocation = new Location(current.location.location[0], current.location.location[1]+1);
            break;
            case LEFT: newTileLocation = new Location(current.location.location[0]-1, current.location.location[1]);
            default: newTileLocation = new Location(0,0);
        }

        newTile.location = newTileLocation;

        //Add doors to tile
        newTile.doors = getNeighbouringDoors(newTile);
        newTile.mapTiles = getNeighbouringTiles(newTile);
    }

    public MapTile getTileByLocation(int x, int y){
        if(map.indexOf(new Location(x,y)) != -1){
            return map.get(map.indexOf(new Location(x,y)));
        }else
            return null;
    }

    public MapTile[] getNeighbouringTiles(MapTile current){
        int x,y;
        x= current.location.location[0];
        y=current.location.location[1];
        MapTile[] tiles = new MapTile[4];
        //up
        try{
            tiles[0] = map.get(map.indexOf(new Location(x,y-1))).mapTiles[MapTile.DIRECTION.DOWN.ordinal()];
        }catch (IndexOutOfBoundsException e){
            tiles[0] = null;
        }
        //right
        try{
            tiles[1] = map.get(map.indexOf(new Location(x+1,y))).mapTiles[MapTile.DIRECTION.LEFT.ordinal()];
        }catch (IndexOutOfBoundsException e){
            tiles[1] = null;
        }
        //down
        try{
            tiles[2] = map.get(map.indexOf(new Location(x,y+1))).mapTiles[MapTile.DIRECTION.UP.ordinal()];
        }catch (IndexOutOfBoundsException e){
            tiles[2] = null;
        }
        //left
        try{
            tiles[3] = map.get(map.indexOf(new Location(x-1,y))).mapTiles[MapTile.DIRECTION.RIGHT.ordinal()];
        }catch (IndexOutOfBoundsException e){
            tiles[3] = null;
        }
        return tiles;
    }
    
    public Door[] getNeighbouringDoors(MapTile current){
        int x,y;
        x= current.location.location[0];
        y=current.location.location[1];
        Door[] doors = new Door[4];
        //up
        try{
            doors[0] = map.get(map.indexOf(new Location(x,y-1))).doors[MapTile.DIRECTION.DOWN.ordinal()];
        }catch (IndexOutOfBoundsException e){
            doors[0] = new Door();
        }
        //right
        try{
            doors[1] = map.get(map.indexOf(new Location(x+1,y))).doors[MapTile.DIRECTION.LEFT.ordinal()];
        }catch (IndexOutOfBoundsException e){
            doors[1] = new Door();
        }
        //down
        try{
            doors[2] = map.get(map.indexOf(new Location(x,y+1))).doors[MapTile.DIRECTION.UP.ordinal()];
        }catch (IndexOutOfBoundsException e){
            doors[2] = new Door();
        }
        //left
        try{
            doors[3] = map.get(map.indexOf(new Location(x-1,y))).doors[MapTile.DIRECTION.RIGHT.ordinal()];
        }catch (IndexOutOfBoundsException e){
            doors[3] = new Door();
        }
        return doors;
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

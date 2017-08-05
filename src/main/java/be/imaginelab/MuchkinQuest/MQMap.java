package be.imaginelab.MuchkinQuest;

import be.imaginelab.MuchkinQuest.MapTiles.Location;
import be.imaginelab.MuchkinQuest.MapTiles.MapTile;
import be.imaginelab.MuchkinQuest.MapTiles.TileArmoury;
import be.imaginelab.MuchkinQuest.MapTiles.TileStart;
import be.imaginelab.MuchkinQuest.Treasures.Treasure;

import java.util.*;

/**
 * Created by arthu on 5/06/2017.
 */
public class MQMap {

    //All remaining cards in the deck
    public List<MapTile> deck = new ArrayList<>();

    //Map is a list of tiles linked together
    MapTile startTile = new TileStart();
    List<MapTile> map = new ArrayList<>();

    //Monster, Player and Item locations are stored in a HashMap for easy access;
    public Map<MapTile, List<Treasure>> itemLocations = new HashMap<>();
    public Map<MapTile, List<Monster>> monsterLocations = new HashMap<>();
    public Map<Player, MapTile> playerLocations = new HashMap<>();

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
            case UP: newTileLocation = new Location(current.location.x, current.location.y-1);
            break;
            case RIGHT: newTileLocation = new Location(current.location.x+1, current.location.y);
            break;
            case DOWN: newTileLocation = new Location(current.location.x, current.location.y+1);
            break;
            case LEFT: newTileLocation = new Location(current.location.x-1, current.location.y);
            break;
            default: newTileLocation = new Location(0,0);
        }

        newTile.location = newTileLocation;

        //Add doors to tile
        newTile.doors = getNeighbouringDoors(newTile);
        newTile.neighbours = getNeighbouringTiles(newTile);
        updateNeighbours(newTile);
        map.add(newTile);
    }

    public MapTile getTileByLocation(int x, int y){
        if(map.indexOf(new Location(x,y)) != -1){
            return map.get(map.indexOf(new Location(x,y)));
        }else
            return null;
    }

    public MapTile[] getNeighbouringTiles(MapTile current){
        int x,y;
        x= current.location.x;
        y=current.location.y;
        MapTile[] tiles = new MapTile[4];
        //up
        try{
            tiles[0] = map.get(map.indexOf(new Location(x,y-1)));
        }catch (IndexOutOfBoundsException e){
            tiles[0] = null;
        }
        //right
        try{
            tiles[1] = map.get(map.indexOf(new Location(x+1,y)));
        }catch (IndexOutOfBoundsException e){
            tiles[1] = null;
        }
        //down
        try{
            tiles[2] = map.get(map.indexOf(new Location(x,y+1)));
        }catch (IndexOutOfBoundsException e){
            tiles[2] = null;
        }
        //left
        try{
            tiles[3] = map.get(map.indexOf(new Location(x-1,y)));
        }catch (IndexOutOfBoundsException e){
            tiles[3] = null;
        }
        return tiles;
    }
    
    public Door[] getNeighbouringDoors(MapTile current){
        int x,y;
        x= current.location.x;
        y=current.location.y;
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

    private void updateNeighbours(MapTile current){
        int x,y;
        x= current.location.x;
        y=current.location.y;
        //up
        try{
            map.get(map.indexOf(new Location(x,y-1))).neighbours[MapTile.DIRECTION.DOWN.ordinal()] = current;
        }catch (IndexOutOfBoundsException e){        }
        //right
        try{
            map.get(map.indexOf(new Location(x+1,y))).neighbours[MapTile.DIRECTION.LEFT.ordinal()] = current;
        }catch (IndexOutOfBoundsException e){        }
        //down
        try{
            map.get(map.indexOf(new Location(x,y+1))).neighbours[MapTile.DIRECTION.UP.ordinal()] = current;
        }catch (IndexOutOfBoundsException e){        }
        //left
        try{
            map.get(map.indexOf(new Location(x-1,y))).neighbours[MapTile.DIRECTION.RIGHT.ordinal()] = current;
        }catch (IndexOutOfBoundsException e){        }
    }

    public void setPlayerOnStartTile(Player player){
        playerLocations.put(player, map.get(0));
    }
    public boolean isAnyPlayerOnTile(MapTile tile){
        return playerLocations.containsValue(tile);
    }

    public boolean monsterOnPlayerTile(Player player){
        if(monsterLocations.get(playerLocations.get(player)) == null){
            return false;
        }else {
            return true;
        }

    }

    public List<Monster> findMonstersCloseTo(MapTile mapTile, int size){
        List<Monster> monsters = new ArrayList<>();
        for(int i = 0; i<size; i++){
            for(int j = 0; j<4; j++){
                MapTile tile = mapTile.neighbours[j];
                monsters.addAll(monsterLocations.get(tile));
            }
        }
        return monsters;
    }

    public void moveMonsterTowards(List<Monster> monsters, MapTile tile){
        //TODO implement method
        //Just move in relative direction based on location
        //AND THE MOVES HAVE TO BE LEGAL
    }

    @Override
    public String toString(){
        String string = "";
        Collections.sort(map);
        int y = map.get(0).location.y;
        for(MapTile tile : map){
            System.out.print("\t" + tile);
            System.out.println("\t" + tile.location);
        }

        return string;
    }

}

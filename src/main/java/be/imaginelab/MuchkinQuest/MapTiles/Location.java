package be.imaginelab.MuchkinQuest.MapTiles;

/**
 * Created by Arthur on 28/07/2017.
 */
public class Location {

    public int x, y = 0;

    public Location(){}
    public Location(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof MapTile){
            return this.isSame(((MapTile) o).location);
        }

        if(o instanceof Location){
            return this.isSame(((Location) o));
        }

        return false;
    }

    public boolean isSame(Location location){
        if(location.x == x && location.y == y)
            return true;
        return false;
    }

    @Override
    public String toString(){
        return "(" + x + ", " + y + ")";
    }
}

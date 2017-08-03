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
    public String toString(){
        return "(" + x + ", " + y + ")";
    }
}

package be.imaginelab.MuchkinQuest.MapTiles;

/**
 * Created by Arthur on 28/07/2017.
 */
public class Location {

    public int[] location;

    public Location(){
        location = new int[]{0,0};
    }
    public Location(int x, int y){
        this.location = new int[]{x,y};
    }
}

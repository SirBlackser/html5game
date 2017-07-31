package be.imaginelab.MuchkinQuest;

import java.util.Random;

/**
 * Created by arthu on 21/03/2017.
 */
public class Door {
    enum DOORTYPE{
        NORMAL,
        WALL,
        HIDDEN,
        LOCKED,
        JUNKY
    }

    DOORTYPE type;

    public Door(){
        Random random = new Random();
        int randInt = random.nextInt(100);
        //TODO values to be tweaked
        //25% chance of normal door
        if(randInt > 0 && randInt <= 30){
            this.type = DOORTYPE.NORMAL;
        }else if(randInt > 30 && randInt <= 60){
            this.type = DOORTYPE.JUNKY;
        }else if(randInt > 60 && randInt <= 75){
            this.type = DOORTYPE.WALL;
        }else if(randInt > 75 && randInt <= 90){
            this.type = DOORTYPE.LOCKED;
        }else if(randInt > 90 && randInt <= 100){
            this.type = DOORTYPE.HIDDEN;
        }
    }
}

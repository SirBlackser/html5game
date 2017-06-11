package be.imaginelab.MuchkinQuest;

/**
 * Created by arthu on 11/06/2017.
 */
public class Colors {
    static enum COLOR{
        BLUE,
        RED,
        GREEN,
        YELLOW;
        private static COLOR[] vals = values();
        public COLOR next()
        {
            return vals[(this.ordinal()+1) % vals.length];
        }
    }

    public COLOR color;

    public COLOR getNext(){
        return color.next();
    }
}

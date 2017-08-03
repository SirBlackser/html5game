package be.imaginelab.MuchkinQuest.DXMs;

import be.imaginelab.MuchkinQuest.MQMap;
import be.imaginelab.MuchkinQuest.MunchkinQuest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arthu on 21/03/2017.
 */
public abstract class DXM {

    protected MunchkinQuest munchkinQuest;

    public String name = null;
    public String mainText = null;
    public String description = null;

    public DXM(MunchkinQuest munchkinQuest){
        this.munchkinQuest = munchkinQuest;
    }

    protected int getExtraLevel(){return 0;}
    //can Use?
    //protected abstract boolean canUseNow(MunchkinQuest munchkinQuest);
    //Select target from list?
    //protected abstract List<Object> canUseOn(MunchkinQuest munchkinQuest);
    //use on target
    protected abstract void use(Object target);

    @Override
    public String toString(){
        return name;
    }
}

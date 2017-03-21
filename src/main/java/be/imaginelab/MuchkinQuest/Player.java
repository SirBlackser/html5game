package be.imaginelab.MuchkinQuest;

import java.util.List;

enum COLOR{
    BLUE,
    RED,
    GREEN,
    YELLOW
}

/**
 * Created by arthu on 21/03/2017.
 */
public class Player {



    public COLOR color = COLOR.RED;

    public int health = 4;
    public int moves = 3;
    public int gold = 300;
    public int level = 1;

    public List<DXM> dxms;
    public List<Treasure> treasures;

    /*
    *Init player with color, 3 DXM and 3 treasure
     */
    public Player(COLOR color, List<DXM> dxms, List<Treasure> treasures){
        this.color = color;
        this.dxms.addAll(dxms);
        this.treasures.addAll(treasures);
    }
}

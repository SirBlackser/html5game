package be.imaginelab.MuchkinQuest;

import be.imaginelab.MuchkinQuest.DXMs.BermudaTriangle;
import be.imaginelab.MuchkinQuest.DXMs.Classes.Cleric;
import be.imaginelab.MuchkinQuest.DXMs.ConvenientAdditionError;
import be.imaginelab.MuchkinQuest.DXMs.Curses.*;
import be.imaginelab.MuchkinQuest.DXMs.Curses.MonsterMovement.MonsterMagnetism;
import be.imaginelab.MuchkinQuest.DXMs.Curses.MonsterMovement.RulesChange;
import be.imaginelab.MuchkinQuest.DXMs.Curses.MonsterMovement.SmellsLikeDinner;
import be.imaginelab.MuchkinQuest.DXMs.DXM;
import be.imaginelab.MuchkinQuest.DXMs.DispelMonster;
import be.imaginelab.MuchkinQuest.DXMs.EquipmentModifiers.Cheat;
import be.imaginelab.MuchkinQuest.DXMs.MonsterModifiers.*;
import be.imaginelab.MuchkinQuest.MapTiles.MapTile;
import be.imaginelab.MuchkinQuest.Treasures.Treasure;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by arthu on 21/03/2017.
 */
public class MunchkinQuest {

    public static boolean isDebug = true;

    public static void main(String args[]){
        new MunchkinQuest();
    }

    public MunchkinQuest(){
        JFrame f = new JFrame("MyFrame");
        Canvas c = new Canvas();
        Terminal t = new Terminal(this);
        c.addMouseListener(t);
        c.addKeyListener(t);
        c.setVisible(true);

        f.add(c);
        f.setSize(new Dimension(400,400));
        f.setVisible(true);

        //System.out.println(Monster.SIZE.TINY.ordinal());

        init(2);

    }

    public int numPlayers = 2;
    Player[] players;

    List<DXM> dxms = new ArrayList<DXM>();
    List<Treasure> treasures = new ArrayList<Treasure>();

    MQMap MQMap = new MQMap(this);

    public void init(int numPlayers){

        //TODO Spawn random DXM deck
        initDXM();
        //TODO Spawn random Treasure deck
        initTreasure();
        //TODO Spawn random Monster deck

        this.numPlayers = numPlayers;
        players = new Player[numPlayers];
        //init players
        Colors colors = new Colors();
        for(int i = 0; i < numPlayers; i++){
            //TODO get 3 random dxm
            List<DXM> dxms = getDXM(3);
            //TODO get 3 random treasures
            List<Treasure> treasures = getTreasure(3);
            players[i] = new Player(colors.getNext(), this, dxms, treasures);
            getMQMap().playerLocations.put(players[i], getMQMap().startTile);
        }

        //TODO roll for turn order

        //TODO all players may play races, classes and items to set up their character

        //TODO Start game
        players[0].isActive = true;
        players[0].startTurn();

    }

    private void initDXM(){
        //Incomplete non-random deck
        //DXMs
        //Classes
        dxms.add(new Cleric(this));
        //Curses
            //MonsterMovement
            dxms.add(new MonsterMagnetism(this));
            dxms.add(new RulesChange(this));
            dxms.add(new SmellsLikeDinner(this));
        dxms.add(new ArmorTurnsToPudding(this));
        dxms.add(new ChangeSex(this));
        dxms.add(new HoleInPocket(this));
        dxms.add(new ItemCatchesFire(this));
        dxms.add(new OneHandTiedBehindYourBack(this));
        dxms.add(new RippedPack(this));
        dxms.add(new ShoelacesTiedTogether(this));
        dxms.add(new WarrantyExpires(this));
        dxms.add(new WindsOfFate(this));
        //Equipment modifiers
        dxms.add(new Cheat(this));
        //MonsterModifiers
        dxms.add(new Ancient(this));
        dxms.add(new Armored(this));
        dxms.add(new Baby(this));
        dxms.add(new ColdlyRational(this));
        dxms.add(new Demonic(this));
        //other
        dxms.add(new BermudaTriangle(this));
        dxms.add(new ConvenientAdditionError(this));
        dxms.add(new DispelMonster(this));
    }

    public void initTreasure(){
        treasures.add(new Treasure());
        treasures.add(new Treasure());
        treasures.add(new Treasure());
        treasures.add(new Treasure());
        treasures.add(new Treasure());
        treasures.add(new Treasure());
        treasures.add(new Treasure());
        treasures.add(new Treasure());
        treasures.add(new Treasure());
        treasures.add(new Treasure());
        treasures.add(new Treasure());
        treasures.add(new Treasure());

    }

    public MQMap getMQMap(){
        return MQMap;
    }
    public MapTile getMQStartTile() {return MQMap.map.get(0);}


    public List<DXM> getDXM(int number){
        List<DXM> chosen = new ArrayList<>();
        Random random = new Random(System.currentTimeMillis());
        for(int i = 0; i < number; i++){
            int c = random.nextInt(dxms.size());
            chosen.add(dxms.get(c));
            dxms.remove(c);
        }
        return chosen;
    }

    public List<Treasure> getTreasure(int number){
        List<Treasure> chosen = new ArrayList<>();
        Random random = new Random(System.currentTimeMillis());
        for(int i = 0; i < number; i++){
            int c = random.nextInt(treasures.size());
            chosen.add(treasures.get(c));
            treasures.remove(c);
        }
        return chosen;
    }
}

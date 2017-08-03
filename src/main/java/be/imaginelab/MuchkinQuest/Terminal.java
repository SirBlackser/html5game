package be.imaginelab.MuchkinQuest;

import be.imaginelab.MuchkinQuest.DXMs.DXM;

import java.awt.event.*;
import java.io.IOException;
import java.util.EventListener;

/**
 * Created by Arthur on 31/07/2017.
 */
public class Terminal implements MouseListener, KeyListener{
    MunchkinQuest munchkinQuest;
    public Terminal(MunchkinQuest munchkinQuest){
        this.munchkinQuest = munchkinQuest;
        System.out.println("Type '?' for help.");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //System.out.println("Click");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //System.out.println("Pressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //System.out.println("Released");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //System.out.println("Entered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //System.out.println("Exited");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //System.out.println("Typed");
        switch (e.getKeyChar()){
            //Player actions
            //TODO exit room
            //TODO search
            //TODO pick up
            //TODO make deal
            //TODO sell
            //TODO die
            //TODO End turn
            case 'h':
                System.out.println("Current Hand:");
                for(DXM dxm : munchkinQuest.activePlayer.dxms){
                    System.out.println("\t" + dxm);
                }
                break;
            case 'e':
                System.out.println("ended Turn");
                munchkinQuest.nextPlayer();
                break;
            case 'm':
                System.out.println("Map:");
                System.out.println(munchkinQuest.getMQMap());
                break;
            case '?':
                System.out.println("Help:");
                System.out.println("\th: Show Hand");
                System.out.println("\te: End turn.");
                System.out.println("\tm: Map details");
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println("Pressed");
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
                //System.out.println("Up");
                break;
            case KeyEvent.VK_RIGHT:
                break;
            case KeyEvent.VK_DOWN:
                break;
            case KeyEvent.VK_LEFT:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //System.out.println("Released");
    }
}

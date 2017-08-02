package be.imaginelab.MuchkinQuest.DXMs.Classes;

import be.imaginelab.MuchkinQuest.DXMs.Curses.Curse;
import be.imaginelab.MuchkinQuest.DXMs.DXM;
import be.imaginelab.MuchkinQuest.DXMs.MonsterModifiers.Ancient;
import be.imaginelab.MuchkinQuest.MunchkinQuest;
import be.imaginelab.MuchkinQuest.Player;

/**
 * Created by Arthur on 01/08/2017.
 */
public class Cleric extends Class {
    public Cleric(MunchkinQuest munchkinQuest){
        super(munchkinQuest);
        name = "CLERIC";
        description = "Roll one extra die when fighting Undead.\n Discard a card at any time, even during combat to restore one hit to any player.\n d10 Power: Remove one curse from any munchkin or cancel one Curse as it occurs. You may make one attempt on each munchkin's turn.";
    }

    @Override
    public void rollD10(Player receiver) {

        //if success
        if(tryD10()){
            //TODO select curse
            removeCurseFromPlayer(receiver);
        }
        //else do nothing

        canD10 = false;
    }

    @Override
    public void onCurse(Player owner, Curse curse) {
        //Player want to remove curse?
        if(tryD10()){
            curse.remove();
        }

        canD10 = false;
    }

    private void removeCurseFromPlayer(Player receiver){
        //TODO Wait for selection
    }

    @Override
    public void specialSkill(Player owner, Player receiver) {
        //TODO Select card to discard
        DXM dxm = new Ancient(munchkinQuest); //TODO REMOVE MOCK DXM
        owner.dxms.remove(dxm);
        receiver.modifyHealth(+1);

    }
}

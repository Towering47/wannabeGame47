package wannabeGame.Events;

import wannabeGame.Exceptions.*;
import wannabeGame.Classes.*;
import wannabeGame.Entities.*;

public class Fountain extends Event {
    
    public Fountain() {}    

    @Override
    public void interact(Player player) throws FinishGameException {
        System.out.println("You approach a fountian, your health is restored");
        System.out.println("Player HP: " + player.getCurrentHP()+"/"+player.getMaxHP()+" --> "+player.getMaxHP()+"/"+player.getMaxHP());
        player.setCurrentHP(player.getMaxHP());
    }

    @Override
    public String tileIcon() {
        return "\u001B[34m"+"{}"+"\u001B[0m";
    }

    @Override
    public String toString() {
        return "{}";
    }
}

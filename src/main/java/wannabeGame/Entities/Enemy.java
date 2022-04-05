package wannabeGame.Entities;

import wannabeGame.Exceptions.*;
import wannabeGame.Classes.*;
import wannabeGame.Interfaces.*;

public class Enemy extends Entity {
    
    public Enemy(int hp,int atk) {
        super(hp, atk);
    }

    @Override
    public void interact(Player player) throws FinishGameException {
        
        if (Interactions.Battle(player, this)) {
            System.out.printf("Enemy Killed!!\n");
            return;
        }
        else {
            throw new FinishGameException("Dead to Enemy");
        }
    }

    @Override
    public String tileIcon() {
        return "\u001B[31m"+"E"+"\u001B[0m";
    }

    @Override
    public String toString() {
        return "Enemy Stats\nHP: " + curr_hp + "/" + max_hp + "\nATK: " + atk_power + "\n";
    }
}
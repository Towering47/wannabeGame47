package wannabeGame.Entities;

import wannabeGame.Classes.*;

public class Player extends Entity {
    
    public Player(int hp,int atk) {
        super(hp, atk);
    }

    @Override
    public String tileIcon() {
        return "P";
    }

    @Override
    public String toString() {
        return "Player Stats\nHP: " + curr_hp + "/" + max_hp + "\nATK: " + atk_power + "\n";
    }
    
}

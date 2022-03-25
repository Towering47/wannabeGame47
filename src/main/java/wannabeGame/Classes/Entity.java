package wannabeGame.Classes;

import wannabeGame.Entities.*;

public abstract class Entity extends TileInteraction {
    
    protected int max_hp;
    protected int curr_hp;
    protected int atk_power;

    public Entity (int hp,int atk) {
        max_hp = hp;
        curr_hp = hp;
        atk_power = atk;
    }

    public int getAtkPower() { return atk_power;}
    public void setAtkPower(int atk) { atk_power = atk;}

    public int getMaxHP() { return max_hp;}
    public void setMaxHP(int hp) { max_hp = hp;}
    
    
    public int getCurrentHP() { return curr_hp;}
    public void setCurrentHP(int hp) { curr_hp = hp;}
    public void takeDamage(int dmg) { curr_hp = curr_hp - dmg;}

    @Override
    public void interact(Player player) throws Exception {
        System.out.printf("interacted\n");
    }

    @Override
    public String tileIcon() {
        return "T";
    }

    @Override
    public String toString() {
        return "T";
    }
    
}

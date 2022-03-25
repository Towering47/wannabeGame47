package wannabeGame.Classes;

import wannabeGame.Entities.*;

public abstract class TileInteraction {
    
    public TileInteraction() {}

    public void interact(Player player) throws Exception {
        System.out.printf("interacted\n");
    }

    public String tileIcon() {
        return "ERROR";
    }

    @Override
    public String toString() {
        return "ERROR";
    }
}

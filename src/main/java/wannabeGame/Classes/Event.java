package wannabeGame.Classes;

import wannabeGame.Entities.*;

public abstract class Event extends TileInteraction {
    
    public Event () {}

    @Override
    public void interact(Player player) throws Exception {
        System.out.printf("event triggered\n");
    }

    @Override
    public String tileIcon() {
        return "ERROR";
    }
    
}

package wannabeGame.Events;

import wannabeGame.Exceptions.*;
import wannabeGame.Classes.*;
import wannabeGame.Entities.*;

public class End extends Event {
    
    public End() {}

    @Override
    public void interact(Player player) throws FinishGameException {
        throw new FinishGameException("End reached");
    }

    @Override
    public String tileIcon() {
        return "Ye";
    }

    @Override
    public String toString() {
        return "Ye";
    }
    
}

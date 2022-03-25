package wannabeGame.Events;

import wannabeGame.Exceptions.*;
import wannabeGame.Classes.*;
import wannabeGame.Entities.*;

public class TheEnd extends Event {
    
    public TheEnd() {}

    @Override
    public void interact(Player player) throws FinishGameException {
        throw new FinishGameException("End reached");
    }

    @Override
    public String tileIcon() {
        return "F";
    }

    @Override
    public String toString() {
        return "F";
    }
    
}

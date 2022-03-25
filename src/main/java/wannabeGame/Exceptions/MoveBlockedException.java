package wannabeGame.Exceptions;

public class MoveBlockedException extends Exception {

    public MoveBlockedException() {}

    public String toString() { return "MOVEBLOCKED : Can't move in that direction";}
}
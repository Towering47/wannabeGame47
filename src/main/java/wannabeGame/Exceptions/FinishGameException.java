package wannabeGame.Exceptions;

public class FinishGameException extends Exception {

    String message;
    public FinishGameException(String string) { message = string;}

    public String toString() { return message;}
    
}

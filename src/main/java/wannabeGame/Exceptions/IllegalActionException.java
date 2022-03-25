package wannabeGame.Exceptions;

public class IllegalActionException extends Exception {

    String error_message;
    public IllegalActionException(String string) { error_message = string;}

    public String toString() { return "ILLEGAL ACTION : " + error_message + "\n";}
}
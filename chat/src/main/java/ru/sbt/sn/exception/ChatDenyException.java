package ru.sbt.sn.exception;

public class ChatDenyException extends Exception {
    public ChatDenyException() {
        super();
    }

    public ChatDenyException( String message ) {
        super( message );
    }

    public ChatDenyException( String message, Throwable cause ) {
        super( message, cause );
    }
}

package org.acme.exception;

public class InvalidUserException extends RuntimeException{
    public InvalidUserException(String e){
        super(e);
    }
}

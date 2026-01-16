package org.acme.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String e){
        super(e);
    }
}

package com.atnt.training1.userDemo.exception;

public class UserNotFoundException  extends RuntimeException{
    public UserNotFoundException(final String message) {
        super(message);
    }

}

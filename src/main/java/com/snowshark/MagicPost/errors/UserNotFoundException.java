package com.snowshark.MagicPost.errors;

public class UserNotFoundException extends Exception{
    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String messege) {
        super(messege);
    }

}

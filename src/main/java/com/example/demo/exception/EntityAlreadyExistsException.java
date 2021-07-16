package com.example.demo.exception;

public class EntityAlreadyExistsException extends RuntimeException{

    String message = "";

    public EntityAlreadyExistsException(){
        super();
    }

    public EntityAlreadyExistsException(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}

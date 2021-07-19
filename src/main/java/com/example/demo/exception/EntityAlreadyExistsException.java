package com.example.demo.exception;

public class EntityAlreadyExistsException extends RuntimeException{

    String message = "";

    public EntityAlreadyExistsException(){
        super();
    }

    public EntityAlreadyExistsException(String message){
        this.message = message;
    }

    public EntityAlreadyExistsException(String message, Object... parameters){
        this.message = String.format(message, parameters);
    }

    public String getMessage(){
        return this.message;
    }
}

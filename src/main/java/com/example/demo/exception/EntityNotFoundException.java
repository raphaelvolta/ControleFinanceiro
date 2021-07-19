package com.example.demo.exception;

public class EntityNotFoundException extends RuntimeException{

    String message = "";

    public EntityNotFoundException(){
        super();
    }

    public EntityNotFoundException(String message){
        this.message = message;
    }

    public EntityNotFoundException(String message, Object... parameters){
        this.message = String.format(message, parameters);
    }

    public String getMessage(){
        return this.message;
    }
}

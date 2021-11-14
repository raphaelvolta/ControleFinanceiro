package com.example.demo.exception;

public class EntityBeingUsedException extends RuntimeException {
    String message = "";

    public EntityBeingUsedException(){
        super();
    }

    public EntityBeingUsedException(String message){
        this.message = message;
    }

    public EntityBeingUsedException(String message, Object... parameters){
        this.message = String.format(message, parameters);
    }

    public String getMessage(){
        return this.message;
    }
}
package com.example.demo.exception;

public class EntityNotFoundException extends RuntimeException{

    String message = "";

    public EntityNotFoundException(){
        super();
    }

    public EntityNotFoundException(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}

package com.warehouse.warehouse.Exceptions;

public class ObjectNotFoundException extends RuntimeException{
    public ObjectNotFoundException(Integer id){
        super("Couldn't find object with id: " + id);
    }
}

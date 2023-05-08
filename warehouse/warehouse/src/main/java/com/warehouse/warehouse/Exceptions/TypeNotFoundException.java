package com.warehouse.warehouse.Exceptions;

public class TypeNotFoundException extends  RuntimeException{
    public TypeNotFoundException(Integer id){
        super("Couldn't find type with id: " + id);
    }
}

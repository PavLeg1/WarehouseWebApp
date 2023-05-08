package com.warehouse.warehouse.Exceptions;

public class StaffNotFoundException extends RuntimeException{
    public StaffNotFoundException(Integer id){
        super("Couldn't find staff with id: " + id);
    }
}

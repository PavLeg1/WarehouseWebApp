package com.warehouse.warehouse.Exceptions;

public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException(Long id){
        super("Couldn't find client with id: " + id);
    }
}

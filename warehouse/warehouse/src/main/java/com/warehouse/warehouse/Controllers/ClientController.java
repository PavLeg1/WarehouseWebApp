package com.warehouse.warehouse.Controllers;

import com.warehouse.warehouse.Exceptions.ClientNotFoundException;
import com.warehouse.warehouse.Exceptions.CustomNotFoundException;
import com.warehouse.warehouse.Models.Client;
import com.warehouse.warehouse.Models.Object;
import com.warehouse.warehouse.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody Client client){
    clientService.saveClient(client);
    return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public List<Client> getAll(){
        return clientService.getAllClients();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        clientService.deleteClientById(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Integer id){
        try{
            Client client =clientService.getClientById(id);
            return ResponseEntity.ok(client);
        }
        catch(ClientNotFoundException ex){
            //return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            throw new CustomNotFoundException(HttpStatus.NOT_FOUND, "We're sorry to say that client with ID: " + id + " doesn't exist...");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Client client, @PathVariable Integer id){
        try{
            Client _client = clientService.getClientById(id);
            _client.updateClient(client);
            clientService.saveClient(_client);
            return ResponseEntity.ok(client);
        }
        catch (ClientNotFoundException ex){
            throw new CustomNotFoundException(HttpStatus.NOT_FOUND, "We're sorry to say that client with ID: " + id + " doesn't exist...");
        }
    }
}

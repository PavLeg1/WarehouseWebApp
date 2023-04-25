package com.warehouse.warehouse.Controllers;

import com.warehouse.warehouse.Models.Client;
import com.warehouse.warehouse.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping("/")
    public void save(@RequestBody Client client){
    clientService.saveClient(client);
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
    public ResponseEntity<?> getById(@PathVariable Integer id){
        try{
            Client client =clientService.getClientById(id);
            return new ResponseEntity<Client>(client, HttpStatus.OK);
        }
        catch(NoSuchElementException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Client client, @PathVariable Integer id){
        try{
            Client _client = clientService.getClientById(id);
            _client.updateClient(client);
            clientService.saveClient(_client);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (NoSuchElementException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

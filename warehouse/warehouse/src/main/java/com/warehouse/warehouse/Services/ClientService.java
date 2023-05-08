package com.warehouse.warehouse.Services;

import com.warehouse.warehouse.Exceptions.ClientNotFoundException;
import com.warehouse.warehouse.Models.Client;
import com.warehouse.warehouse.Repos.ClientRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ClientService {
    @Autowired
    private ClientRepo clientRepo;

    public List<Client> getAllClients() {
        return clientRepo.findAll();
    }

    public Client saveClient(Client client){
        return clientRepo.save(client);
    }

    public Client getClientById(Integer id) {
        return clientRepo.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
    }

    public void deleteClientById(Integer id){
        Client client = getClientById(id);
        clientRepo.delete(client);
    }
}

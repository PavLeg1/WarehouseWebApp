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
public class ClientService{
    @Autowired
    ClientRepo clientRepo;

//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    public void addClient(Client client) {
//        client.setPassword(passwordEncoder.encode(client.getPassword()));
//        clientRepo.save(client);
//    }

    public List<Client> getAllClients() {
        return clientRepo.findAll();
    }

//    public boolean existsByUsername(String username) {
//        return clientRepo.existsByUsername(username);
//    }

    public Long saveClient(Client client){
        return clientRepo.save(client).getId();
    }

    public Client getClientById(Long id) {
        return clientRepo.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
    }

//    public boolean isAdmin(String username) {
//        return clientRepo.getClientByUsername(username).getRoles().contains(Roles.admin);
//    }

    public void deleteClientById(Long id){
        Client client = getClientById(id);
        clientRepo.delete(client);
    }

}

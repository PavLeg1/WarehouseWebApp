package com.warehouse.warehouse.Repos;

import com.warehouse.warehouse.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client, Long> {
    Client findByUsername(String username);
    public Client getClientByUsername(String username);
//    boolean existsByUsername(String username);

}

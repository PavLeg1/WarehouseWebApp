package com.warehouse.warehouse.Repos;

import com.warehouse.warehouse.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepo extends JpaRepository<Client, Integer> {
    List<Client> findByFirstName(String firstName);
}

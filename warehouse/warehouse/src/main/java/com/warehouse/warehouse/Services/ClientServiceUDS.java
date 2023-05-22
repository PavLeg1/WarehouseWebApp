package com.warehouse.warehouse.Services;

import com.warehouse.warehouse.Models.Client;
import com.warehouse.warehouse.Repos.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class ClientServiceUDS implements UserDetailsService {

    @Autowired
    ClientRepo clientRepo;
    /**
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = clientRepo.findByUsername(username);
        if(client == null) {
            throw new UsernameNotFoundException("There is no such username: " + username);
        }
        return client;
    }
}

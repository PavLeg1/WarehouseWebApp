package com.warehouse.warehouse.Controllers;

import com.warehouse.warehouse.Exceptions.ClientNotFoundException;
import com.warehouse.warehouse.Exceptions.CustomNotFoundException;
import com.warehouse.warehouse.Models.Client;
import com.warehouse.warehouse.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    ClientService clientService;

//    @Autowired
//    PasswordEncoder passwordEncoder;

//    @PostMapping("/")
//    public ResponseEntity<?> save(@RequestBody Client client){
//    clientService.addClient(client);
//    return ResponseEntity.ok().build();
//    }

//    @PostMapping("/register")
//    public ResponseEntity<?> register(@Validated @RequestBody Client client){
//        if (clientService.existsByUsername(client.getUsername())) {
//            return ResponseEntity.badRequest().body("Username \" "+client.getUsername()+ "\" isn't available");
//        }
//        client.setPassword(passwordEncoder.encode(client.getPassword()));
//        client.setRoles(List.of(Roles.client));
//        //client.setEnabled(true);
//        Long id = clientService.saveClient(client);
//        return new ResponseEntity<>("New user is created, id: "+id, HttpStatus.OK);
//    }



    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody Client client){
        clientService.saveClient(client);
        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public List<Client> getAll(){
        return clientService.getAllClients();
    }

//    @GetMapping("/page")
//    public String getClientsPage() {
//        return "outputClients.html";
//    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        clientService.deleteClientById(id);
    }

//    @PostMapping("/auth/register")
//    public String addNewUser(@ModelAttribute Client client, @RequestParam String username, @RequestParam String roles, HttpSession session) {
//        System.out.println("Client object is: " + client);
//        clientService.saveClient(client);
//        session.setAttribute("username", username);
//        session.setAttribute("roles", roles);
//        return "/";
//    }
//    @GetMapping("/auth/register")
//    public String register(HttpServletRequest request, HttpServletResponse response) {
//        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
//        return "/login_page";
//    }



    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id){
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
    public ResponseEntity<?> update(@RequestBody Client client, @PathVariable Long id){
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

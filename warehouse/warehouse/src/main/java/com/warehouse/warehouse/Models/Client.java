package com.warehouse.warehouse.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.Set;

@Entity
@Table(name="clients")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private String mail;
    private Date birthDate;

    public void updateClient(Client client){
    if(client.firstName != null)    { this.firstName = client.firstName; }

    if(client.lastName != null)     { this.lastName = client.lastName; }

    if(client.address != null)      { this.address = client.address; }

    if(client.phone != null)        { this.phone = client.phone; }

    if(client.mail != null)         { this.mail = client.mail; }

    if(client.birthDate != null)    { this.birthDate = client.birthDate; }
    }

    // Connection with ORDER table
    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private Set<Order> orders;

}

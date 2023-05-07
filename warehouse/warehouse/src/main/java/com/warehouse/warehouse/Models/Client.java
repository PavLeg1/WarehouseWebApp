package com.warehouse.warehouse.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="clients")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phone;
    @Column(name = "mail")
    private String mail;
    @Column(name = "birthDate")
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
    private List<Order> orders;

}

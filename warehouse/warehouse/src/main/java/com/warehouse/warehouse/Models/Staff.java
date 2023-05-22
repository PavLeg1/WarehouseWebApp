package com.warehouse.warehouse.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name= "staff")
@Data
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "post")
    private String post;

    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phone;
    @Column(name = "birthDate")
    private Date birthDate;

    public void updateStaff(Staff staff){
        if (staff.firstName != null)        { this.firstName = staff.firstName; }

        if (staff.lastName != null)         { this.lastName = staff.lastName; }

        if (staff.post != null)             { this.post = staff.post; }

        if (staff.address != null)          { this.address = staff.address; }

        if (staff.phone != null)            { this.phone = staff.phone; }

        if (staff.birthDate != null)        { this.birthDate = staff.birthDate; }

        if(staff.orders != null)            {this.orders = staff.orders; }
    }

    // Connection with ORDER table
    @JsonIgnore
    @OneToMany(mappedBy = "staff")
    private List<Order> orders;
}

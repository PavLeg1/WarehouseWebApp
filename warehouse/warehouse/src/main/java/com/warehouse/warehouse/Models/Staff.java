package com.warehouse.warehouse.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.Set;

@Entity
@Table(name= "staff")
@Data
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;
    private String post;
    private Float salary;
    private String address;
    private String phone;
    private Date birthDate;

    public void updateStaff(Staff staff){
        if (staff.firstName != null)        { this.firstName = staff.firstName; }

        if (staff.lastName != null) { this.lastName = staff.lastName; }

        if (staff.post != null)     { this.post = staff.post; }

        if (staff.salary != null)        { this.salary = staff.salary; }

        if (staff.address != null)     { this.address = staff.address; }

        if (staff.phone != null)    { this.phone = staff.phone; }

        if (staff.birthDate != null) { this.birthDate = staff.birthDate; }
    }

    // Connection with ORDER table
    @JsonIgnore
    @OneToMany(mappedBy = "staff")
    private Set<Order> order;
}

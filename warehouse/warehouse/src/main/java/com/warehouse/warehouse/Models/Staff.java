package main.java.com.warehouse.warehouse.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

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
    private String phone;
    private Date birthDate;
    private String address;
}

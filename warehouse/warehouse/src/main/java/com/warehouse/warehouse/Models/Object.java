package main.java.com.warehouse.warehouse.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="object")
@Data
public class Object {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;
    private String address;
    private Float rent;
    private Float area;
    private Float capacity;
    private Float rent_for_m2;
}

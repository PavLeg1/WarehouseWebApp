package main.java.com.warehouse.warehouse.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name= "types")
@Data
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Float size;
    private Float base_price;
}

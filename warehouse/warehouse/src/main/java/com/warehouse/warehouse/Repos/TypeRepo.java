package com.warehouse.warehouse.Repos;

import com.warehouse.warehouse.Models.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TypeRepo extends JpaRepository<Type, Integer> {
    List<Type> findByCategory(String category);
}

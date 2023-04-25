package com.warehouse.warehouse.Repos;

import com.warehouse.warehouse.Models.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StaffRepo extends JpaRepository<Staff, Integer> {
    List<Staff> findByFirstName(String firstName);
}

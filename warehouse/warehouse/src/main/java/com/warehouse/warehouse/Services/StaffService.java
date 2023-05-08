package com.warehouse.warehouse.Services;

import com.warehouse.warehouse.Exceptions.StaffNotFoundException;
import com.warehouse.warehouse.Models.Staff;
import com.warehouse.warehouse.Repos.StaffRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StaffService {
    @Autowired
    private StaffRepo staffRepo;

    public List<Staff> getAllStaff() {
        return staffRepo.findAll();
    }

    public Staff saveStaff(Staff staff){
        return staffRepo.save(staff);
    }

    public Staff getStaffById(Integer id){
        return staffRepo.findById(id).orElseThrow(() -> new StaffNotFoundException(id));
    }

    public void deleteStaff(Integer id){
        Staff staff = getStaffById(id);
        staffRepo.delete(staff);
    }
}


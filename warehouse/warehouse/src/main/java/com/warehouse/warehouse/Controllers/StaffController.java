package com.warehouse.warehouse.Controllers;

import com.warehouse.warehouse.Exceptions.CustomNotFoundException;
import com.warehouse.warehouse.Exceptions.StaffNotFoundException;
import com.warehouse.warehouse.Models.Staff;
import com.warehouse.warehouse.Services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody Staff staff){
        staffService.saveStaff(staff);
        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public List<Staff> getAll(){
        return staffService.getAllStaff();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        staffService.deleteStaff(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        try{
            Staff staff =staffService.getStaffById(id);
            return ResponseEntity.ok(staff);
        }
        catch(StaffNotFoundException ex){
            throw new CustomNotFoundException(HttpStatus.NOT_FOUND, "We're sorry to say that staff with ID: " + id + " doesn't exist...");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Staff staff, @PathVariable Integer id){
        try{
            Staff _staff = staffService.getStaffById(id);
            _staff.updateStaff(staff);
            staffService.saveStaff(_staff);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (StaffNotFoundException ex){
            throw new CustomNotFoundException(HttpStatus.NOT_FOUND, "We're sorry to say that object with ID: " + id + " doesn't exist...");
        }
    }
}


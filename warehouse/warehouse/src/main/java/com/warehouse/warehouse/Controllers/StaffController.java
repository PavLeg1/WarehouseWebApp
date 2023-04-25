package com.warehouse.warehouse.Controllers;

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
    public void save(@RequestBody Staff staff){
        staffService.saveStaff(staff);
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
            return new ResponseEntity<Staff>(staff, HttpStatus.OK);
        }
        catch(NoSuchElementException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Staff staff, @PathVariable Integer id){
        try{
            Staff _staff = staffService.getStaffById(id);
            _staff.updateStaff(staff);
            staffService.saveStaff(_staff);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (NoSuchElementException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


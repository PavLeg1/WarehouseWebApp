package com.warehouse.warehouse.Controllers;

import com.warehouse.warehouse.Exceptions.CustomNotFoundException;
import com.warehouse.warehouse.Exceptions.ObjectNotFoundException;
import com.warehouse.warehouse.Models.Object;
import com.warehouse.warehouse.Services.ObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/objects")
public class ObjectController {
    @Autowired
    private ObjectService objectService;

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody Object object){
        objectService.saveObject(object);
        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public List<Object> getAll(){
        return objectService.getAllObjects();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        objectService.deleteObject(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getObjectById(@PathVariable Integer id){
        try{
            Object object =objectService.getObjectsById(id);
            return ResponseEntity.ok(object);
        }
        catch(ObjectNotFoundException ex){
            throw new CustomNotFoundException(HttpStatus.NOT_FOUND, "We're sorry to say that object with ID: " + id + " doesn't exist...");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Object object, @PathVariable Integer id){
        try{
            Object _object = objectService.getObjectsById(id);
            _object.updateObject(object);
            objectService.saveObject(_object);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (ObjectNotFoundException ex){
            throw new CustomNotFoundException(HttpStatus.NOT_FOUND, "We're sorry to say that object with ID: " + id + " doesn't exist...");
        }
    }
}


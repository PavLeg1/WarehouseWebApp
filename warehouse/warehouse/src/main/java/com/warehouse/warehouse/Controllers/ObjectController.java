package com.warehouse.warehouse.Controllers;

import com.warehouse.warehouse.Models.Object;
import com.warehouse.warehouse.Services.ObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/objects")
public class ObjectController {
    @Autowired
    private ObjectService objectService;

    @PostMapping("/")
    public void save(@RequestBody Object object){
        objectService.saveObject(object);
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
    public ResponseEntity<?> getById(@PathVariable Integer id){
        try{
            Object object =objectService.getObjectsById(id);
            return new ResponseEntity<Object>(object, HttpStatus.OK);
        }
        catch(NoSuchElementException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
        catch (NoSuchElementException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


package com.warehouse.warehouse.Controllers;

import com.warehouse.warehouse.Exceptions.CustomNotFoundException;
import com.warehouse.warehouse.Exceptions.TypeNotFoundException;
import com.warehouse.warehouse.Models.Type;
import com.warehouse.warehouse.Services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/types")
public class TypeController {
    @Autowired
    private TypeService typeService;

    /*@PostMapping("/")
    public void save(@RequestBody Type type){
        typeService.saveType(type);
    }*/
    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody Type type){
        typeService.saveType(type);
        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public List<Type> getAllTypes(){
        return typeService.getAllTypes();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        typeService.deleteType(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTypeById(@PathVariable Integer id){
        try{
            Type type = typeService.getTypeById(id);
            return ResponseEntity.ok(type);
        }
        catch(TypeNotFoundException ex){
            throw new CustomNotFoundException(HttpStatus.NOT_FOUND, "We're sorry to say that type with ID: " + id + " doesn't exist...");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Type type, @PathVariable Integer id){
        try{
            Type _type = typeService.getTypeById(id);
            _type.updateType(type);
            typeService.saveType(_type);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (TypeNotFoundException ex){
            throw new CustomNotFoundException(HttpStatus.NOT_FOUND, "We're sorry to say that type with ID: " + id + " doesn't exist...");
        }
    }
}


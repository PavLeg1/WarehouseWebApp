package com.warehouse.warehouse.Controllers;

import com.warehouse.warehouse.Models.Type;
import com.warehouse.warehouse.Services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/types")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @PostMapping("/")
    public void save(@RequestBody Type type){
        typeService.saveType(type);
    }

    @GetMapping("")
    public List<Type> getAll(){
        return typeService.getAllTypes();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        typeService.deleteType(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        try{
            Type type =typeService.getTypeById(id);
            return new ResponseEntity<Type>(type, HttpStatus.OK);
        }
        catch(NoSuchElementException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
        catch (NoSuchElementException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


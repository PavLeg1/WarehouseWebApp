package com.warehouse.warehouse.Services;

import com.warehouse.warehouse.Exceptions.ObjectNotFoundException;
import com.warehouse.warehouse.Models.Object;
import com.warehouse.warehouse.Repos.ObjectRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ObjectService {
    @Autowired
    ObjectRepo objectRepo;

    public List<Object> getAllObjects() {
        return objectRepo.findAll();
    }

    public Object saveObject(Object object){
        return objectRepo.save(object);
    }

    public Object getObjectsById(Integer id){
        return objectRepo.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
    }

    public void deleteObject(Integer id){
        Object object = getObjectsById(id);
        objectRepo.delete(object);
    }
}


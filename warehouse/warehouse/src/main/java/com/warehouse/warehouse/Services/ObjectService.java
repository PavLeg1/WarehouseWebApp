package com.warehouse.warehouse.Services;

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
    private ObjectRepo objectRepo;

    public List<Object> getAllObjects() {
        return objectRepo.findAll();
    }

    public void saveObject(Object object){
        objectRepo.save(object);
    }

    public Object getObjectsById(Integer id){
        return objectRepo.findById(id).get();
    }

    public void deleteObject(Integer id){
        objectRepo.deleteById(id);
    }
}


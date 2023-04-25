package com.warehouse.warehouse.Services;

import com.warehouse.warehouse.Models.Type;
import com.warehouse.warehouse.Repos.TypeRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TypeService {
    @Autowired
    private TypeRepo typeRepo;

    public List<Type> getAllTypes() {
        return typeRepo.findAll();
    }

    public void saveType(Type type){
        typeRepo.save(type);
    }

    public Type getTypeById(Integer id){
        return typeRepo.findById(id).get();
    }

    public void deleteType(Integer id){
        typeRepo.deleteById(id);
    }
}

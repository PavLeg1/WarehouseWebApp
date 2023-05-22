package com.warehouse.warehouse.Services;

import com.warehouse.warehouse.Exceptions.TypeNotFoundException;
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
    TypeRepo typeRepo;

    public List<Type> getAllTypes() {
        return typeRepo.findAll();
    }

    public Type saveType(Type type){
        return typeRepo.save(type);
    }

    public Type getTypeById(Integer id){
        return typeRepo.findById(id).orElseThrow(() -> new TypeNotFoundException(id));
    }

    public void deleteType(Integer id){
        Type type = getTypeById(id);
        typeRepo.delete(type);
    }
}

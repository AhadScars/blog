package com.Api.Api.controller;

import com.Api.Api.model.Registration;
import com.Api.Api.service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Controller_model {

    @Autowired
    service serviceModel;


  @DeleteMapping("/delete")
    public void deleteAll(){
        serviceModel.deleteAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleyeById(@PathVariable Integer id){
        serviceModel.deleteById(id);
    }


    @PostMapping("/addUser")
    public Registration add(@RequestBody Registration modelRegister){
        return serviceModel.registerUser(modelRegister);
    }

        @GetMapping("/showall")
    public List<Registration> showall(){
        return serviceModel.getAll();
    }

    @GetMapping("/showbyId/{id}")
    public Optional<Registration> findbyId(@PathVariable Integer id){
        return serviceModel.findById(id);
    }



}

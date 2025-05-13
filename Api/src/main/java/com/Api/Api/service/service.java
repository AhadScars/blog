package com.Api.Api.service;

import com.Api.Api.model.Registration;
import com.Api.Api.model.userPrinciple;
import com.Api.Api.repository.Repository_model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class service implements UserDetailsService {



    @Autowired
    Repository_model repositoryModel;
    private final BCryptPasswordEncoder passwordEncoder= new BCryptPasswordEncoder();


    public List<Registration> getAll(){
        return repositoryModel.findAll();
    }

    public Optional<Registration> findById(Integer id){
        return repositoryModel.findById(id);
    }

    public Registration registerUser(Registration registration){
        registration.setPassword(passwordEncoder.encode(registration.getPassword()));
        return repositoryModel.save(registration);
    }

    public void deleteAll(){
        repositoryModel.deleteAll();
    }

    public void deleteById(Integer id){
        repositoryModel.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Registration user = repositoryModel.findByUsername(username);
        return new userPrinciple(user);
    }
}

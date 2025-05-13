package com.Api.Api.repository;

import com.Api.Api.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repository_model extends JpaRepository<Registration,Integer>{

    Registration findByUsername(String username);

}

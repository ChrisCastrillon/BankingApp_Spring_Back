package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Application;
import com.revature.models.User;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer>{
    public Application findByApplicationOwner(User owner);
    public Application findByApplicationId(int applicationId);
    public List<Application> findAll();
    public Application save(Application application);
    
}

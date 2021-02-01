package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Application;
import com.revature.repositories.ApplicationRepository;

@RestController
@RequestMapping("/application")
public class ApplicationController {
    
    @Autowired
    private ApplicationRepository applicationDao;
    
    @GetMapping("/applications")
    public ResponseEntity<List<Application>> getAllApplications() {
        return ResponseEntity.ok(applicationDao.findAll());
    }
       
}

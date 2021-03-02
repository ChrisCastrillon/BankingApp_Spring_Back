package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Application;
import com.revature.repositories.ApplicationRepository;
import com.revature.services.ApplicationService;
import com.revature.templates.ApplicationFormTemplate;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/application")
public class ApplicationController {
    
    @Autowired
    private ApplicationRepository applicationDAO;
    @Autowired
    private ApplicationService appService;
    
    @GetMapping("/applications")
    public ResponseEntity<List<Application>> getAllApplications() {
        return ResponseEntity.ok(applicationDAO.findAll());
    }
    @PostMapping("/submit")
    public ResponseEntity<Application> submitApplication(@RequestBody ApplicationFormTemplate appTemp) {
        Application app = appService.applicationFormToApplication(appTemp);
        if (app != null) {

            return ResponseEntity.ok(app);
        }
        return ResponseEntity.badRequest().build();
    }
       
}

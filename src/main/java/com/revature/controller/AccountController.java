package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Account;
import com.revature.repositories.AccountRepository;
import com.revature.repositories.UserRepository;
import com.revature.services.IAccountService;

import lombok.extern.log4j.Log4j2;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/accounts")
public class AccountController {
    
    @Autowired
    private IAccountService accountService;
    @Autowired
    private AccountRepository accountDao;
    @Autowired
    private UserRepository userDao;
    
    
    @GetMapping("/{userId}")
    @ResponseBody
    public ResponseEntity<List<Account>> getAllAccountsByUserId(@PathVariable(name="userId") String userId){
        List<Account> accounts = accountService.findAccountsByUserId(userId);
        if(accounts.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(accounts);
    }
    

}

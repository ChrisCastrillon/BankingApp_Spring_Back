package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Account;
import com.revature.repositories.AccountRepository;

@Service
public class AccountService implements IAccountService {
    
    @Autowired
    private AccountRepository accountDao;
    @Override
    public List<Account> findAccountsByUserId(String userId) {
        int intUserId = Integer.valueOf(userId);
        return accountDao.findAllByUserId(intUserId);
    }

}

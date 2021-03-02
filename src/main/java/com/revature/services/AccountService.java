package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Account;
import com.revature.repositories.AccountRepository;
import com.revature.templates.TransferFormTemplate;

@Service
public class AccountService implements IAccountService {
    
    @Autowired
    private AccountRepository accountDao;
    @Override
    public List<Account> findAccountsByUserId(String userId) {
        int intUserId = Integer.valueOf(userId);
        return accountDao.findAllByUserId(intUserId);
    }
    
    @Override
    public List<Account> transferToAccount(TransferFormTemplate tft) {
        List<Account> accs = new ArrayList<>();
        System.out.println(tft.getFromAccountNumber());
        Account fromAccount = accountDao.findByAccountNumber(tft.getFromAccountNumber());
        
        Account toAccount = accountDao.findByAccountNumber(tft.getToAccountNumber());
        
        fromAccount = withdrawFromAccount(fromAccount, tft.getTransferAmount());
        toAccount = depositToAccount(toAccount, tft.getTransferAmount());
        accs.add(fromAccount);
        accs.add(toAccount);
        return accs;
    }
    
    @Override
    public Account depositToAccount(Account toAccount, double amount) {
        toAccount.setBalance(toAccount.getBalance() + amount);
        accountDao.save(toAccount);
        return toAccount;
    }
    
    @Override
    public Account withdrawFromAccount(Account fromAccount, double amount) {
        fromAccount.setBalance(fromAccount.getBalance()-amount);
        accountDao.save(fromAccount);
        return fromAccount;
    }
    

}

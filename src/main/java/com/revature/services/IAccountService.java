package com.revature.services;

import java.util.List;

import com.revature.models.Account;
import com.revature.templates.TransferFormTemplate;

public interface IAccountService {
    public List<Account> findAccountsByUserId(String user_id);
    public List<Account> transferToAccount(TransferFormTemplate tft);
    public Account withdrawFromAccount(Account fromAccount, double amount);
    public Account depositToAccount(Account toAccount, double amount);
}

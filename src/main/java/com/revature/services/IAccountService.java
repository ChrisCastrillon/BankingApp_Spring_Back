package com.revature.services;

import java.util.List;

import com.revature.models.Account;

public interface IAccountService {
    public List<Account> findAccountsByUserId(String user_id);
}

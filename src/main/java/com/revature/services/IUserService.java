package com.revature.services;

import com.revature.models.User;

public interface IUserService {
    public User login(String username, String password);
}

package com.revature.services;

import com.revature.models.User;
import com.revature.templates.CreateUserFormTemplate;
import com.revature.templates.LoginFormTemplate;

public interface IUserService {
    public User login(LoginFormTemplate lft);
    public User addNewUser(CreateUserFormTemplate cuft);
}

package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repositories.UserRepository;
import com.revature.templates.CreateUserFormTemplate;
import com.revature.templates.LoginFormTemplate;

@Service
public class UserService implements IUserService{
    @Autowired
    private UserRepository userDAO;

    @Override
    public User login(LoginFormTemplate lft) {
        User u = userDAO.findByUsername(lft.getUsername());
        if(!u.getPassword().equals(lft.getPassword())) {
            return null;
        }
        return u;
    }

    @Override
    public User addNewUser(CreateUserFormTemplate cuft) {
        User u = new User(0, Role.User, cuft.getFirstname(), cuft.getLastname(), null, 
                cuft.getUsername(), cuft.getPassword(), cuft.getEmail(), null, null, null);
        
        return userDAO.save(u);
    }

}

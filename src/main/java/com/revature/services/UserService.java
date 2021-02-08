package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.repositories.UserRepository;
import com.revature.templates.LoginFormTemplate;

@Service
public class UserService implements IUserService{
    @Autowired
    private UserRepository userDAO;

    @Override
    public User login(LoginFormTemplate lft) {
        User u = userDAO.findByUsername(lft.getUsername());
        return u;

//        try {
//            return userDAO.findByUsername(lft.getUsername());
//        }
//        catch(NullPointerException e) {
//            e.printStackTrace();
//            return null;
//        }
        
    }
    

}

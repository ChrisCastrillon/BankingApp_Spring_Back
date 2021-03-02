package com.revature.templates;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class CreateUserFormTemplate {
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String password;

}

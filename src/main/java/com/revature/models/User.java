package com.revature.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="banking_users")
@Data @NoArgsConstructor @AllArgsConstructor
public class User implements Serializable {
    
   

    

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer userId;
    private Role userRole;
    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    @NotNull
    private Integer ssn;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String email;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Address> addresses;
    
    @OneToMany(mappedBy="accountOwner")
    private Set<Account> accounts;
   
    private Application application;
    
    

}

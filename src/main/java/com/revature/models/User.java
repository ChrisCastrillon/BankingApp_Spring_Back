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

import com.sun.istack.internal.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="banking_users")
@Data @NoArgsConstructor @AllArgsConstructor  @EqualsAndHashCode(exclude= {"addresses", "accounts"}) @ToString(exclude= {"addresses","accounts"})
public class User implements Serializable {

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
    
    public User(int id, Role role, String firstname, String lastname, Integer ssn, String username, String password, String email, Set<Address> addresses) {
        this.userId = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.ssn = ssn;
        this.username = username;
        this.password = password;
        this.email = email;
        this.addresses = addresses;
    }
    
    

}

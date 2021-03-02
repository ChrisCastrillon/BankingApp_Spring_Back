package com.revature.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name ="user_account")
@Data @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(exclude= {"accountOwner"}) @ToString(exclude= {"accountOwner"})
public class Account implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = -4698619226853715509L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int accountNumber;
    
    @NotNull
    private AccountType accountType;
    private double balance;
    
    @Getter(AccessLevel.NONE)
    @ManyToOne
    @JoinColumn(name="userId", nullable=false)
    private User accountOwner;
    
    
    
}

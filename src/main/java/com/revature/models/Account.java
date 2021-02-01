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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="user_account")
@Data @NoArgsConstructor @AllArgsConstructor
public class Account implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = -4698619226853715509L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer accountNumber;
    
    @NotNull
    private AccountType accountType;
    private double balance;
    @ManyToOne
    @JoinColumn(name="userId", nullable=false)
    private User accountOwner;
    
    
    
}

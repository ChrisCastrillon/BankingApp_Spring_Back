package com.revature.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name ="account_application")
@Data @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(exclude= {"applicationOwner"}) @ToString(exclude={"applicationOwner"})
public class Application implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 3557091551662212134L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int applicationId;
    @NotNull
    private AccountType accountType;
    @NotNull
    private double income;
    @NotNull
    private String jobTitle;
    @Getter(AccessLevel.NONE)
    private User applicationOwner;

}

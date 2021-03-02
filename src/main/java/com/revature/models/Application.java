package com.revature.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
    private Integer applicationId;
    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    @NotNull
    private int ssn;
    @NotNull
    private double salary;
    @NotNull
    private String jobTitle;
    @NotNull
    private AccountType accountType;
    @NotNull
    private String email;
//    @Getter(AccessLevel.NONE)
    @JsonBackReference
    @ManyToOne
    private User applicationOwner;

}

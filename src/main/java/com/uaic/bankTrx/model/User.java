package com.uaic.bankTrx.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class User implements ControlFields{

    private String name;
    private Double amount;

    @Id @GeneratedValue
    private Long id;


    public User(String name, Double amount)
    {
        this.name=name;
        this.amount=amount;
    }

}

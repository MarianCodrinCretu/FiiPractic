package com.uaic.bankTrx.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;


@Data
@NoArgsConstructor
@Entity
public class Transaction implements ControlFields {

    @Id @GeneratedValue
    private Long id;
    private Long fromUser;
    private Long toUser;
    private Double amount;

    Transaction (Long fromUser, Long toUser, Double amount)
    {
        this.fromUser=fromUser;
        this.toUser=toUser;
        this.amount=amount;
    }





}

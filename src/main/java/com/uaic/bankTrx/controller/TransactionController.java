package com.uaic.bankTrx.controller;

import com.uaic.bankTrx.miscellaneous.NotEnoughFoundsException;
import com.uaic.bankTrx.miscellaneous.UserNotFoundException;
import com.uaic.bankTrx.model.Transaction;
import com.uaic.bankTrx.model.User;
import com.uaic.bankTrx.repository.TransactionRepository;
import com.uaic.bankTrx.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionController {

    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;

    public TransactionController(TransactionRepository transactionRepository, UserRepository userRepository) {
        this.transactionRepository = transactionRepository;
        this.userRepository=userRepository;
    }

    @GetMapping("/transactions")
    List<Transaction> all(){return transactionRepository.findAll();}


    @PostMapping("/transactions")
    Transaction newTransaction(@RequestBody Transaction newTransaction)
    {
        User from = userRepository.findById(newTransaction.getFromUser())
                .orElseThrow(()-> new UserNotFoundException(newTransaction.getFromUser()));

        User to = userRepository.findById(newTransaction.getToUser())
                .orElseThrow(()-> new UserNotFoundException(newTransaction.getToUser()));

        if(from.getAmount()> newTransaction.getAmount()) {
            from.setAmount(from.getAmount() - newTransaction.getAmount());
            to.setAmount(to.getAmount() + newTransaction.getAmount());
            userRepository.save(from);
            userRepository.save(to);
            return transactionRepository.save(newTransaction);
        }
        else
        {
            throw new NotEnoughFoundsException(newTransaction.getAmount());
        }
    }







}

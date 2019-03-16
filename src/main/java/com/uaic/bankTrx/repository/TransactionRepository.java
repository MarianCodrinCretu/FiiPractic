package com.uaic.bankTrx.repository;

import com.uaic.bankTrx.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}

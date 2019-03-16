package com.uaic.bankTrx.repository;

import com.uaic.bankTrx.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

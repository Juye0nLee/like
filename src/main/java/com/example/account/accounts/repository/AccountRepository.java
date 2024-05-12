package com.example.account.accounts.repository;

import com.example.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUserId (String userId);
    Optional<Account> findByPassword (String password);
}

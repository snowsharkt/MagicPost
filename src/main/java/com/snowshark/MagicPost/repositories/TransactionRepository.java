package com.snowshark.MagicPost.repositories;

import com.snowshark.MagicPost.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}

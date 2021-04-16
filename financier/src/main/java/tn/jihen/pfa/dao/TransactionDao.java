package tn.jihen.pfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.jihen.pfa.model.Transaction;

import java.util.Date;
import java.util.Optional;

@Repository
public interface TransactionDao extends JpaRepository<Transaction, Integer> {
    Optional<Transaction> findByDate(Date date);
}

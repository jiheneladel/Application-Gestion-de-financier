package tn.jihen.pfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.jihen.pfa.model.Personne;
import tn.jihen.pfa.model.Session;
import tn.jihen.pfa.model.Transaction;

import java.util.Collection;


@Repository
public interface TransactionDao extends JpaRepository<Transaction, Integer> {
    Collection<Transaction> findAllByIdClientAndSession(Personne idClient, Session session);
}

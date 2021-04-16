package tn.jihen.pfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.jihen.pfa.model.TypeTransaction;

import java.util.Optional;

@Repository
public interface TypeTransactionDao extends JpaRepository<TypeTransaction, Integer> {
    TypeTransaction findByLibelle(String libelle);
}

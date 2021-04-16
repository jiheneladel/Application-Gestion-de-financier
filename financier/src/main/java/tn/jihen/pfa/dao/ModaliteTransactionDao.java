package tn.jihen.pfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.jihen.pfa.model.ModaliteTransaction;

import java.util.Optional;

@Repository
public interface ModaliteTransactionDao extends JpaRepository<ModaliteTransaction, Integer> {
    ModaliteTransaction findByLibelle(String libelle);
}

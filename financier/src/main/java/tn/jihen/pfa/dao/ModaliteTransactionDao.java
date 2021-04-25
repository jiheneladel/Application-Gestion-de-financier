package tn.jihen.pfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.jihen.pfa.model.ModaliteTransaction;

@Repository
public interface ModaliteTransactionDao extends JpaRepository<ModaliteTransaction, Integer> {

}

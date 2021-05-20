package tn.jihen.pfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.jihen.pfa.model.Nationalite;

@Repository
public interface NationaliteDao extends JpaRepository<Nationalite, Integer> {
    Nationalite findByLibelle(String libelle);
}

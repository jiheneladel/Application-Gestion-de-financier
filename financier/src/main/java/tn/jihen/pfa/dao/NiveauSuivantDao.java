package tn.jihen.pfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.jihen.pfa.model.NiveauSuivant;
@Repository
public interface NiveauSuivantDao extends JpaRepository<NiveauSuivant, Integer> {
}

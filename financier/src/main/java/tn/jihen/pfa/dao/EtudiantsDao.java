package tn.jihen.pfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.jihen.pfa.model.Etudiants;

@Repository
public interface EtudiantsDao extends JpaRepository<Etudiants, Integer> {
}

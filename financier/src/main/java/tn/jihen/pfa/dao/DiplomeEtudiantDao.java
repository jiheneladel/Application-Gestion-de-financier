package tn.jihen.pfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.jihen.pfa.model.DiplomeEtudiant;
@Repository
public interface DiplomeEtudiantDao extends JpaRepository<DiplomeEtudiant,Integer> {
}

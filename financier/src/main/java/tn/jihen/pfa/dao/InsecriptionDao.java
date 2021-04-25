package tn.jihen.pfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.jihen.pfa.model.Etudiants;
import tn.jihen.pfa.model.Inscription;
@Repository
public interface InsecriptionDao extends JpaRepository<Inscription, Integer> {
    Inscription findByIdEtudiant(Etudiants idEtudiant);
}

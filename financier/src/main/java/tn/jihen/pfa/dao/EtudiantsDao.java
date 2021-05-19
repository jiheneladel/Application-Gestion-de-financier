package tn.jihen.pfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.jihen.pfa.model.Etudiants;

import java.util.Optional;

@Repository
public interface EtudiantsDao extends JpaRepository<Etudiants, Integer> {
    Optional<Etudiants> findByIdEtudiant(int idEtudiant);

    Etudiants findById(Etudiants etudiants);
}

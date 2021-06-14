package tn.jihen.pfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.jihen.pfa.model.Personne;

import java.util.Optional;

@Repository
public interface PersonneDao extends JpaRepository<Personne, Integer> {
    Boolean existsByNumeroIdentificateur(String numeroIdentificateur);
    Optional<Personne> findByNomAndPrenom(String nom, String prenom);

}

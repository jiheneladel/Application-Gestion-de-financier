package tn.jihen.pfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.jihen.pfa.model.Identificateur;

@Repository
public interface IdentificateurDao extends JpaRepository<Identificateur, Integer> {
    Identificateur findByTypeIdentificateur(String typeIdentificateur);
}

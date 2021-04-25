package tn.jihen.pfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.jihen.pfa.model.ContactEtudiant;
@Repository
public interface ContactEtudiantDao extends JpaRepository<ContactEtudiant, Integer> {
}

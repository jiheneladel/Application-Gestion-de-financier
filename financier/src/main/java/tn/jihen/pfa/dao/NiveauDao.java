package tn.jihen.pfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.jihen.pfa.model.Niveau;
@Repository
public interface NiveauDao extends JpaRepository<Niveau, Integer> {
    Niveau findByDescription(String description);
}

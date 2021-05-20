package tn.jihen.pfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.jihen.pfa.model.Parcours;

@Repository
public interface ParcoursDao extends JpaRepository<Parcours, Integer> {
    Parcours findByDescription(String description);

}

package tn.jihen.pfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.jihen.pfa.model.Niveau;
import tn.jihen.pfa.model.Parcours;

import java.util.List;

@Repository
public interface NiveauDao extends JpaRepository<Niveau, Integer> {
    Niveau findByDescription(String description);
    List<Niveau> findByParcours(Parcours parcours);
}

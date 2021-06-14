package tn.jihen.pfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.jihen.pfa.model.Parcours;
import tn.jihen.pfa.model.Specialite;

import java.util.List;

@Repository
public interface ParcoursDao extends JpaRepository<Parcours, Integer> {
    Parcours findByDescription(String description);
    List<Parcours> findBySpecialite(Specialite specialite);

}

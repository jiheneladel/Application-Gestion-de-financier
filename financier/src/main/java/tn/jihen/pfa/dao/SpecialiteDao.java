package tn.jihen.pfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.jihen.pfa.model.Cycle;
import tn.jihen.pfa.model.Specialite;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpecialiteDao extends JpaRepository<Specialite, Integer> {
    Specialite findByDescription(String description);
    List<Specialite> findAllByCycle(Cycle cycle);
}

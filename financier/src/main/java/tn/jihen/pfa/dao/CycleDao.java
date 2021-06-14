package tn.jihen.pfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.jihen.pfa.model.Cycle;

import java.util.Optional;

@Repository
public interface CycleDao extends JpaRepository<Cycle, Integer> {
    Cycle findByDescription(String description);

}

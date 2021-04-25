package tn.jihen.pfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.jihen.pfa.model.Session;
import tn.jihen.pfa.model.Specialite;
@Repository
public interface SpecialiteDao extends JpaRepository<Specialite, Integer> {
    Specialite findByDescription(String description);
}

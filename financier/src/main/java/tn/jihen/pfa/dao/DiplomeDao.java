package tn.jihen.pfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.jihen.pfa.model.Diplome;

@Repository
public interface DiplomeDao extends JpaRepository<Diplome, Integer> {
}

package tn.jihen.pfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.jihen.pfa.model.Compte;

import java.util.Optional;

@Repository
public interface CompteDao extends JpaRepository<Compte,Integer> {
    Optional<Compte> findByLogin(String login);
    Boolean existsByLogin(String login);

}

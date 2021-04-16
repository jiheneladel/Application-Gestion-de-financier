package tn.jihen.pfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.jihen.pfa.model.Session;

import java.util.Optional;

public interface SessionDao extends JpaRepository<Session, Integer> {
    Session findBySession(String session);
}

package tn.jihen.pfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.jihen.pfa.model.Session;


@Repository
public interface SessionDao extends JpaRepository<Session, Integer> {
    Session findBySession(String session);
}

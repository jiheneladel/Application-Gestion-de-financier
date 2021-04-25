package tn.jihen.pfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.jihen.pfa.model.Niveau;
import tn.jihen.pfa.model.PrixNiveauParSession;
import tn.jihen.pfa.model.Session;

import java.util.Collection;
@Repository
public interface PrixNiveauParSessionDao extends JpaRepository<PrixNiveauParSession, Integer> {
    Collection<PrixNiveauParSession> findAllBySession(Session session);

    PrixNiveauParSession findBySessionAndNiveau(Session session, Niveau niveau);
}

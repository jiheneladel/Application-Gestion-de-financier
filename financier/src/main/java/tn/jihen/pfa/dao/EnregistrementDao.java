package tn.jihen.pfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.jihen.pfa.model.Enregistrement;
import tn.jihen.pfa.model.Inscription;
import tn.jihen.pfa.model.Session;

@Repository
public interface EnregistrementDao extends JpaRepository<Enregistrement, Integer> {
    Enregistrement findByIdInscriptionAndAndIdSession(Inscription idInscription, Session idSession);

}

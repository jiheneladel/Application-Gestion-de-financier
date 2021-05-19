package tn.jihen.pfa.strategy.payement.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tn.jihen.pfa.dao.*;
import tn.jihen.pfa.model.*;
import tn.jihen.pfa.strategy.payement.PayementStrategy;
import tn.jihen.pfa.strategy.payement.PayementStrategyName;
import tn.jihen.pfa.util.StudentDebt;

import java.util.Collection;
import java.util.Optional;

@Component
public class PayementStrategyEtudiant implements PayementStrategy {
    @Autowired
    SessionDao sessionDao;
    @Autowired
    TransactionDao transactionDao;
    @Autowired
    PersonneDao personneDao;
    @Autowired
    PrixNiveauParSessionDao prixNiveauParSessionDao;
    @Autowired
    InsecriptionDao insecriptionDao;
    @Autowired
    EnregistrementDao enregistrementDao;
    @Autowired
    EtudiantsDao etudiantsDao;
    @Autowired
    StudentDebt studentDebt;
    @Autowired
    ModaliteTransactionDao modaliteTransactionDao;
     String type;
     String status;

    Etudiants etudiants;
    Session session;

    public void init(int etudiant, String session) {
        this.etudiants = etudiantsDao.findById(etudiants);
        this.session = sessionDao.findBySession(session);
    }

    @Override
    public void payer() {


        Collection<Transaction> transactions = transactionDao.findAllByIdClientAndSession(etudiants.getIdPersonne(),session);
        Inscription inscription = insecriptionDao.findByIdEtudiant(etudiants);
        Enregistrement enregistrement = enregistrementDao.findByIdInscriptionAndAndIdSession(inscription, session);
        PrixNiveauParSession prixNiveauParSession =  prixNiveauParSessionDao.findBySessionAndNiveau(session,enregistrement.getIdNiveau());

    }

    @Override
    public PayementStrategyName getPayementStrategyName() {
        return PayementStrategyName.PAYEMENT_STRATEGY_ETUDIANT;
    }
}

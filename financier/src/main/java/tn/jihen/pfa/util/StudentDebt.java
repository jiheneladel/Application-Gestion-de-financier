package tn.jihen.pfa.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tn.jihen.pfa.dao.EnregistrementDao;
import tn.jihen.pfa.dao.InsecriptionDao;
import tn.jihen.pfa.dao.PrixNiveauParSessionDao;
import tn.jihen.pfa.dao.TransactionDao;
import tn.jihen.pfa.model.*;

import java.util.Collection;

@Component
public class StudentDebt {
    @Autowired
    PrixNiveauParSessionDao prixNiveauParSessionDao;
    @Autowired
    TransactionDao transactionDao;
    @Autowired
    InsecriptionDao insecriptionDao;
    @Autowired
    EnregistrementDao enregistrementDao;

    public double debt(Etudiants etudiants, Session session) {
        Collection<Transaction> transactions = transactionDao.findAllByIdClientAndSession(etudiants.getIdPersonne(), session);
        Inscription inscription = insecriptionDao.findByIdEtudiant(etudiants);
        Enregistrement enregistrement = enregistrementDao.findByIdInscriptionAndAndIdSession(inscription, session);
        PrixNiveauParSession prixNiveauParSession = prixNiveauParSessionDao.findBySessionAndNiveau(session, enregistrement.getIdNiveau());

        double sum = transactions.stream().filter(transaction -> transaction.getType().equals(ETypeTransaction.CREDIT.name())).mapToDouble(Transaction::getMontant).sum();
        return prixNiveauParSession.getMontantNiveau() - sum;
    }
}

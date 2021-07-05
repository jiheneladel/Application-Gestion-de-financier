package tn.jihen.pfa.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tn.jihen.pfa.dao.EnregistrementDao;
import tn.jihen.pfa.dao.InsecriptionDao;
import tn.jihen.pfa.dao.PrixNiveauParSessionDao;
import tn.jihen.pfa.dao.TransactionDao;
import tn.jihen.pfa.model.*;

import java.util.Collection;
import java.util.Optional;

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
        System.out.println("debt enter");
        Collection<Transaction> transactions = transactionDao.findAllByIdClientAndSession(etudiants.getIdPersonne(), session);
        Inscription inscription = insecriptionDao.findByIdEtudiant(etudiants);
        System.out.println(session);
        Enregistrement enregistrement = enregistrementDao.findByIdInscriptionAndAndIdSession(inscription, session);
        System.out.println(enregistrement);

        Optional<PrixNiveauParSession> prixNiveauParSession = prixNiveauParSessionDao.findBySessionAndNiveau(session, enregistrement.getIdNiveau());
        System.out.println(prixNiveauParSession.isPresent());
        System.out.println(prixNiveauParSession.isPresent());
        double sum =0 ;
        if (!transactions.isEmpty()){
            sum = transactions.stream().filter(transaction -> transaction.getType().equals(ETypeTransaction.CREDIT.name())).mapToDouble(Transaction::getMontant).sum();
        }
        return prixNiveauParSession.get().getMontantNiveau() - sum;
    }
}

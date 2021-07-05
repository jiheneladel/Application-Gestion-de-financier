package tn.jihen.pfa.strategy.payement.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tn.jihen.pfa.dao.EtudiantsDao;
import tn.jihen.pfa.model.Etudiants;
import tn.jihen.pfa.model.ModaliteTransaction;
import tn.jihen.pfa.model.Personne;
import tn.jihen.pfa.model.Session;
import tn.jihen.pfa.strategy.payement.PayementStrategy;
import tn.jihen.pfa.strategy.payement.PayementStrategyName;
import tn.jihen.pfa.util.ManageTransaction;
import tn.jihen.pfa.util.StudentDebt;

import java.util.Optional;
import java.util.Set;

@Component
public class PayementStrategyEtudiant implements PayementStrategy {
    @Autowired
    EtudiantsDao etudiantsDao;
    @Autowired
    StudentDebt studentDebt;
    @Autowired
    ManageTransaction manageTransaction;

    @Override
    public void payer(Personne personne, float montant, Session session, String datePayement,
                      int typeTransaction, int statusTransaction, int idFinancier,
                      Set<ModaliteTransaction> modaliteTransactionSet) {
        Optional<Etudiants> etudiant = etudiantsDao.findByIdPersonne(personne);
        if (etudiant.isPresent()) {
            System.out.println(etudiant.get()); System.out.println(session);
            double debt = studentDebt.debt(etudiant.get(), session);
            System.out.println(debt);
            if (debt != 0 || debt <= montant) {
                manageTransaction.add(typeTransaction, statusTransaction, modaliteTransactionSet, personne,
                    session, idFinancier, datePayement, montant);
            }
        }
    }

    @Override
    public PayementStrategyName getPayementStrategyName() {
        return PayementStrategyName.PAYEMENT_STRATEGY_ETUDIANT;
    }
}

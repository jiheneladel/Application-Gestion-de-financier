package tn.jihen.pfa.strategy.payement.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tn.jihen.pfa.dao.*;
import tn.jihen.pfa.strategy.payement.PayementStrategy;
import tn.jihen.pfa.strategy.payement.PayementStrategyName;
import tn.jihen.pfa.util.StudentDebt;

@Component
public class PayementStrategyEtudiant implements PayementStrategy {
    @Autowired
    SessionDao sessionDao;
    @Autowired
    TransactionDao transactionDao;
    @Autowired
    PersonneDao personneDao;
    @Autowired
    EmployerDao employerDao;
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

    @Override
    public void payer() {

    }

    @Override
    public PayementStrategyName getPayementStrategyName() {
        return PayementStrategyName.PAYEMENT_STRATEGY_ETUDIANT;
    }
}

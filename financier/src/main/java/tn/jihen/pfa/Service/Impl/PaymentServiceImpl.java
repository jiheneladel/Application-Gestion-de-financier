package tn.jihen.pfa.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.jihen.pfa.Service.PayementService;
import tn.jihen.pfa.model.ModaliteTransaction;
import tn.jihen.pfa.model.Personne;
import tn.jihen.pfa.model.Session;
import tn.jihen.pfa.strategy.payement.PayementStrategy;
import tn.jihen.pfa.strategy.payement.PayementStrategyFactory;
import tn.jihen.pfa.strategy.payement.PayementStrategyName;

import java.util.Set;

@Service
public class PaymentServiceImpl implements PayementService {
    @Autowired
    private PayementStrategyFactory strategyFactory;

    @Override
    public void studentPay(Personne personne, float montant, Session session, String datePayement,
                           int typeTransaction, int statusTransaction, int idFinancier,
                           Set<ModaliteTransaction> modaliteTransactionSet) {
        PayementStrategy payementStrategy = strategyFactory.findStrategy(PayementStrategyName.PAYEMENT_STRATEGY_ETUDIANT);
        payementStrategy.payer(personne, montant, session, datePayement, typeTransaction,
            statusTransaction,idFinancier, modaliteTransactionSet);
    }

    @Override
    public void salaryPay() {

    }

    @Override
    public void servicePay() {

    }

    @Override
    public void vacatairPay() {

    }

    @Override
    public void avancePay() {

    }

    @Override
    public void rembourcementPay() {

    }
}

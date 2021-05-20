package tn.jihen.pfa.strategy.payement.Impl;

import org.springframework.stereotype.Component;
import tn.jihen.pfa.model.ModaliteTransaction;
import tn.jihen.pfa.model.Personne;
import tn.jihen.pfa.model.Session;
import tn.jihen.pfa.strategy.payement.PayementStrategy;
import tn.jihen.pfa.strategy.payement.PayementStrategyName;

import java.util.Set;

@Component
public class PayementStrategyRemboursement implements PayementStrategy {
    @Override
    public void payer(Personne personne, float montant, Session session, String datePayement, int typeTransaction, int statusTransaction, int idFinancier, Set<ModaliteTransaction> modaliteTransactionSet) {

    }

    @Override
    public PayementStrategyName getPayementStrategyName() {
        return PayementStrategyName.PAYEMENT_STRATEGY_REMBOURSEMENT;
    }
}

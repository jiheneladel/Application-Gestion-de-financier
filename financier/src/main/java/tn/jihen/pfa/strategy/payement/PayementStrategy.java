package tn.jihen.pfa.strategy.payement;

import tn.jihen.pfa.model.ModaliteTransaction;
import tn.jihen.pfa.model.Personne;
import tn.jihen.pfa.model.Session;

import java.util.Set;

public interface PayementStrategy {
    void payer(Personne personne, float montant, Session session, String datePayement, int typeTransaction, int statusTransaction, int idFinancier, Set<ModaliteTransaction> modaliteTransactionSet);

    PayementStrategyName getPayementStrategyName();
}

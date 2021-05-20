package tn.jihen.pfa.Service;

import org.springframework.beans.factory.annotation.Autowired;
import tn.jihen.pfa.model.ModaliteTransaction;
import tn.jihen.pfa.model.Personne;
import tn.jihen.pfa.model.Session;
import tn.jihen.pfa.strategy.payement.PayementStrategyFactory;

import java.util.Set;

public interface PayementService {
   void studentPay(Personne personne, float montant, Session session, String datePayement,
                   int typeTransaction, int statusTransaction, int idFinancier,
                   Set<ModaliteTransaction> modaliteTransactionSet);
   void salaryPay();
   void servicePay();
   void vacatairPay();
   void avancePay();
   void rembourcementPay();

}

package tn.jihen.pfa.strategy.payement.Impl;

import org.springframework.stereotype.Component;
import tn.jihen.pfa.strategy.payement.PayementStrategy;
import tn.jihen.pfa.strategy.payement.PayementStrategyName;
@Component
public class PayementStrategyRemboursement  implements PayementStrategy {
    @Override
    public void payer() {

    }

    @Override
    public PayementStrategyName getPayementStrategyName() {
        return PayementStrategyName.PAYEMENT_STRATEGY_REMBOURSEMENT;
    }
}

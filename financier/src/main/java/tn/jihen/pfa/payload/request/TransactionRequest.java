package tn.jihen.pfa.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TransactionRequest {
    @NotNull
    private Float montant;
    @NotBlank
    private String typeTransaction;
    @NotBlank
    private String modaliteTransaction;
    @NotBlank
    private String session;
    private String remarques;

    public Float getMontant() {
        return montant;
    }

    public void setMontant(Float montant) {
        this.montant = montant;
    }

    public String getTypeTransaction() {
        return typeTransaction;
    }

    public void setTypeTransaction(String typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    public String getModaliteTransaction() {
        return modaliteTransaction;
    }

    public void setModaliteTransaction(String modaliteTransaction) {
        this.modaliteTransaction = modaliteTransaction;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getRemarques() {
        return remarques;
    }

    public void setRemarques(String remarques) {
        this.remarques = remarques;
    }
}

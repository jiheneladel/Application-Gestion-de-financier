package tn.jihen.pfa.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TransactionRequest {
    @NotNull
    private int type;
    @NotNull
     private int modalite;
    @NotBlank
    private String datePayement;
    @NotNull
    private int idFinancier;
    @NotNull
    private int idClient;
    @NotNull
    private int session;
    @NotNull
    private int status;
    @NotNull
    private float montant;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDatePayement() {
        return datePayement;
    }

    public void setDatePayement(String datePayement) {
        this.datePayement = datePayement;
    }

    public int getIdFinancier() {
        return idFinancier;
    }

    public void setIdFinancier(int idFinancier) {
        this.idFinancier = idFinancier;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getSession() {
        return session;
    }

    public void setSession(int session) {
        this.session = session;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Float getMontant() {
        return montant;
    }

    public void setMontant(Float montant) {
        this.montant = montant;
    }

    public int getModalite() {
        return modalite;
    }

    public void setModalite(int modalite) {
        this.modalite = modalite;
    }
}

package tn.jihen.pfa.model;

import javax.persistence.*;

@Entity
@Table
public class ModaliteTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idModaliteTrans;
    private String libelle;
    private  String Description;
    public ModaliteTransaction(){}
    public ModaliteTransaction(Integer idModaliteTrans, String libelle, String description) {
        this.idModaliteTrans = idModaliteTrans;
        this.libelle = libelle;
        Description = description;
    }

    public Integer getIdModaliteTrans() {
        return idModaliteTrans;
    }

    public void setIdModaliteTrans(Integer idModaliteTrans) {
        this.idModaliteTrans = idModaliteTrans;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "ModaliteTransaction{" +
                "idModaliteTrans=" + idModaliteTrans +
                ", libelle='" + libelle + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }
}

package tn.jihen.pfa.model;

import javax.persistence.*;

@Entity
public class NiveauSuivant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    private Niveau idNiveau;
    @OneToOne
    private NiveauSuivant idNiveauSuivant;

    public NiveauSuivant(Niveau idNiveau, NiveauSuivant idNiveauSuivant) {
        this.idNiveau = idNiveau;
        this.idNiveauSuivant = idNiveauSuivant;
    }

    public NiveauSuivant() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Niveau getIdNiveau() {
        return idNiveau;
    }

    public void setIdNiveau(Niveau idNiveau) {
        this.idNiveau = idNiveau;
    }

    public NiveauSuivant getIdNiveauSuivant() {
        return idNiveauSuivant;
    }

    public void setIdNiveauSuivant(NiveauSuivant idNiveauSuivant) {
        this.idNiveauSuivant = idNiveauSuivant;
    }

    @Override
    public String toString() {
        return "NiveauSuivant{" +
                "id=" + id +
                ", idNiveau=" + idNiveau +
                ", idNiveauSuivant=" + idNiveauSuivant +
                '}';
    }
}

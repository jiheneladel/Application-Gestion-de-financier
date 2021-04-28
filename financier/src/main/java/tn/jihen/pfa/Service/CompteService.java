package tn.jihen.pfa.Service;

import tn.jihen.pfa.model.Compte;


public interface CompteService {
    boolean existByLogin(String login);
    Compte addCompte(Compte compte);

}

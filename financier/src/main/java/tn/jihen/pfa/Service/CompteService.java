package tn.jihen.pfa.Service;

import org.springframework.stereotype.Service;
import tn.jihen.pfa.model.Compte;


public interface CompteService {
    boolean existByLogin(String login);
    void addCompte(Compte compte);

}

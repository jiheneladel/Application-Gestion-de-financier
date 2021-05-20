package tn.jihen.pfa.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.jihen.pfa.Service.CompteService;
import tn.jihen.pfa.dao.CompteDao;
import tn.jihen.pfa.model.Compte;

@Service
public class CompteServiceImpl implements CompteService {
    @Autowired
    CompteDao compteDao;

    @Override
    public boolean existByLogin(String login) {
        return compteDao.existsByLogin(login);
    }

    @Override
    public Compte addCompte(Compte compte) {
        return compteDao.save(compte);
    }
}

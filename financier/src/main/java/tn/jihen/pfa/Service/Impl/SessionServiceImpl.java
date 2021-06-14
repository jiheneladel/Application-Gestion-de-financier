package tn.jihen.pfa.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import tn.jihen.pfa.Service.SessionService;
import tn.jihen.pfa.dao.SessionDao;
import tn.jihen.pfa.model.Session;

import java.util.List;

public class SessionServiceImpl implements SessionService {
    @Autowired
    SessionDao sessionDao;
    @Override
    public List<Session> getAll() {
        return sessionDao.findAll();
    }
}

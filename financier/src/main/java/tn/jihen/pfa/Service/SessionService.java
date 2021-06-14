package tn.jihen.pfa.Service;

import org.springframework.beans.factory.annotation.Autowired;
import tn.jihen.pfa.dao.SessionDao;
import tn.jihen.pfa.model.Session;

import java.util.List;
import java.util.Optional;

public interface SessionService {


    List<Session> getAll();
}

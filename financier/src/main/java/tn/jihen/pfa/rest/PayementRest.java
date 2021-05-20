package tn.jihen.pfa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.jihen.pfa.Service.PayementService;
import tn.jihen.pfa.dao.PersonneDao;
import tn.jihen.pfa.dao.SessionDao;
import tn.jihen.pfa.model.Personne;
import tn.jihen.pfa.model.Session;
import tn.jihen.pfa.payload.request.PaymentRequest;

import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/pay/")
//@PreAuthorize("hasRole('ADMIN')")
public class PayementRest {
    @Autowired
    PayementService payementService;
    @Autowired
    PersonneDao personneDao;
    @Autowired
    SessionDao sessionDao;

    @PostMapping("/etudiant")
    public void payEtudiant(@Valid @RequestBody PaymentRequest paymentRequest) {
        Optional<Personne> personne = personneDao.findById(paymentRequest.getPersonne());
        if (personne.isEmpty()) {
            return;
        }
        Optional<Session> session = sessionDao.findById(paymentRequest.getSession());
        if (session.isEmpty()) {
            return;
        }
        payementService.studentPay(personne.get(), paymentRequest.getMontant(), session.get(), paymentRequest.getDatePayement(),
            paymentRequest.getTypeTransaction(), paymentRequest.getStatusTransaction(), paymentRequest.getIdFinancier(),
            paymentRequest.getModaliteTransactionSet());
    }
}

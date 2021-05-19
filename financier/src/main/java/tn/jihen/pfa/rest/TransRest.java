package tn.jihen.pfa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tn.jihen.pfa.dao.*;
import tn.jihen.pfa.model.*;
import tn.jihen.pfa.payload.request.TransactionRequest;
import tn.jihen.pfa.payload.response.MessageResponse;
import tn.jihen.pfa.util.StudentDebt;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/trans/")
//@PreAuthorize("hasRole('ADMIN')")
public class TransRest {
    // @Autowired
    //TypeTransactionDao typeTransactionDao;
    @Autowired
    SessionDao sessionDao;
    @Autowired
    TransactionDao transactionDao;
    @Autowired
    PersonneDao personneDao;
    @Autowired
    EmployerDao employerDao;
    @Autowired
    PrixNiveauParSessionDao prixNiveauParSessionDao;
    @Autowired
    InsecriptionDao insecriptionDao;
    @Autowired
    EnregistrementDao enregistrementDao;
    @Autowired
    EtudiantsDao etudiantsDao;
    @Autowired
    StudentDebt studentDebt;
    @Autowired
    ModaliteTransactionDao modaliteTransactionDao;

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody TransactionRequest transactionRequest) {
        String type;
        String status = "";
        if (transactionRequest.getType() == 1) {
            type = ETypeTransaction.DEBIT.name();
        } else {
            type = ETypeTransaction.CREDIT.name();
        }
        switch (transactionRequest.getStatus()) {
            case 1: {
                status = EStatus.INCOMPLETE.name();
                break;
            }
            case 2: {
                status = EStatus.CANCELED.name();
                break;
            }
            case 3: {
                status = EStatus.COMPLETE.name();
                break;
            }
            case 4:{
                status = EStatus.REJECTED.name();
                break;
            }
        }

        Set<ModaliteTransaction> modaliteTransactions = transactionRequest.getModalite();
        List<ModaliteTransaction> modaliteTransactionList = modaliteTransactionDao.saveAll(modaliteTransactions);
        Personne personne = personneDao.findById(transactionRequest.getIdClient())
                .orElseThrow(() -> new RuntimeException("erreur Personne not found!"));
        Session session = sessionDao.findById(transactionRequest.getSession())
                .orElseThrow(() -> new RuntimeException("erreur Session not found!"));
        Employer employer = employerDao.findById(transactionRequest.getIdFinancier())
                .orElseThrow(() -> new RuntimeException("error financier not found"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate;
        try {
            localDate = LocalDate.parse(transactionRequest.getDatePayement(), formatter);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new MessageResponse("date de transaction invalide!!"));

        }

        Transaction transaction = new Transaction(type, modaliteTransactionList, localDate, employer, personne, session, status,
                transactionRequest.getMontant());
        transactionDao.save(transaction);
        return ResponseEntity.ok(new MessageResponse("votre transaction est effectuer avec succée!!"));
    }

   /* @GetMapping("/debtstudent/{idetudiant}/{idsession}")
        public double getStudentDebt(@PathVariable int idetudiant, @PathVariable int idsession) {
        Etudiants etudiants = etudiantsDao.findById(idetudiant)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Session session = sessionDao.findById(idsession)
                .orElseThrow(() -> new RuntimeException("Session not found"));
        return studentDebt.debt(etudiants, session);
    }*/
}

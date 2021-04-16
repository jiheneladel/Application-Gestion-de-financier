package tn.jihen.pfa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.jihen.pfa.dao.ModaliteTransactionDao;
import tn.jihen.pfa.dao.SessionDao;
import tn.jihen.pfa.dao.TransactionDao;
import tn.jihen.pfa.dao.TypeTransactionDao;
import tn.jihen.pfa.model.Transaction;
import tn.jihen.pfa.payload.request.TransactionRequest;
import tn.jihen.pfa.payload.response.MessageResponse;

import javax.validation.Valid;
import java.time.LocalDate;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/trans/")
public class TransRest {
    @Autowired
    TypeTransactionDao typeTransactionDao;
    @Autowired
    ModaliteTransactionDao modaliteTransactionDao;
    @Autowired
    SessionDao sessionDao;
    @Autowired
    TransactionDao transactionDao;
    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody TransactionRequest transactionRequest){
        Transaction transaction = new Transaction(LocalDate.now(),
                transactionRequest.getMontant(),
                typeTransactionDao.findByLibelle(transactionRequest.getTypeTransaction()),
                modaliteTransactionDao.findByLibelle(transactionRequest.getModaliteTransaction()),
                sessionDao.findBySession(transactionRequest.getSession()),
                transactionRequest.getRemarques());
        transactionDao.save(transaction);
        return ResponseEntity.ok(new MessageResponse("votre transaction est effectuer avec succée!!"));
    }
}

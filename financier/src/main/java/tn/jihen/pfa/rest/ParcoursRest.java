package tn.jihen.pfa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.jihen.pfa.dao.ParcoursDao;
import tn.jihen.pfa.dao.SpecialiteDao;
import tn.jihen.pfa.model.Specialite;
import tn.jihen.pfa.payload.request.CycleRequest;
import tn.jihen.pfa.payload.request.SpecialiteRequest;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/parcours/")
public class ParcoursRest {
    @Autowired
    ParcoursDao parcoursDao;
    @Autowired
    SpecialiteDao specialiteDao;
    @GetMapping("/getall")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<List>(parcoursDao.findAll(), HttpStatus.OK);
    }
    @PostMapping("/getbyid")
    public ResponseEntity<?> getById(@Valid @RequestBody SpecialiteRequest specialiteRequest ){
        return new ResponseEntity<List>(parcoursDao.findBySpecialite(
                specialiteDao.findById(specialiteRequest.getIdspecialite()).get())
                , HttpStatus.OK);
    }
}

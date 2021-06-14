package tn.jihen.pfa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.jihen.pfa.dao.EtudiantsDao;
import tn.jihen.pfa.dao.PersonneDao;
import tn.jihen.pfa.model.Etudiants;
import tn.jihen.pfa.model.Personne;
import tn.jihen.pfa.payload.request.IdentificateurRequest;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/etudiants/")
public class EtudiantRest {

    @Autowired
    EtudiantsDao etudiantsDao;

    @Autowired
    PersonneDao personneDao;

    @GetMapping("/getall")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<List>(etudiantsDao.findAll(), HttpStatus.OK);
    }

    @PostMapping("/getbynumid")
    public ResponseEntity<?> getByNumIdentificateur(@Valid @RequestBody IdentificateurRequest identificateurRequest) {
        List<Etudiants> cinE = new ArrayList<Etudiants>();
        for (Etudiants E : etudiantsDao.findAll()) {
            int idp = E.getIdPersonne().getIdPersonne();
            Personne p = personneDao.findById(idp).get();
            String Identificateur = p.getNumeroIdentificateur();
            if (Identificateur.equalsIgnoreCase(identificateurRequest.getNumidentificateur()))
                cinE.add(E);
        }
        return new ResponseEntity<List>(cinE, HttpStatus.OK);
    }


}

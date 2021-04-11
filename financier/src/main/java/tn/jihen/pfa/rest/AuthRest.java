package tn.jihen.pfa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import tn.jihen.pfa.dao.*;
import tn.jihen.pfa.model.*;
import tn.jihen.pfa.payload.request.LoginRequest;
import tn.jihen.pfa.payload.request.SignupRequest;
import tn.jihen.pfa.payload.response.JwtResponse;
import tn.jihen.pfa.payload.response.MessageResponse;
import tn.jihen.pfa.security.jwt.JwtUtils;
import tn.jihen.pfa.security.service.CompteDetailsImpl;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/")
public class AuthRest {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    CompteDao compteDao;
    @Autowired
    RoleDao  roleDao;
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    PersonneDao personneDao;
    @Autowired
    IdentificateurDao identificateurDao;
    @Autowired
    NationaliteDao nationaliteDao;
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getLogin(),
                        loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        CompteDetailsImpl compteDetails = (CompteDetailsImpl) authentication.getPrincipal();
        List<String> role = compteDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        return ResponseEntity.ok(new JwtResponse(jwt, compteDetails.getId(), role,compteDetails.getFirstname(), compteDetails.getLastname()));
    }
    @PostMapping("/signup")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> signup(@Valid @RequestBody SignupRequest signupRequest){
     if (compteDao.existsByLogin(signupRequest.getLogin())){
         return ResponseEntity.badRequest().body(new MessageResponse("login indisponible"));
     }
     if (personneDao.existsByNumeroIdentificateur(signupRequest.getNumeroIdentificateur())){
         return ResponseEntity.badRequest().body(new MessageResponse("numero identification deja existan!!"));
     }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
     LocalDate localDate;
        try {
            localDate = LocalDate.parse(signupRequest.getDateDeNaissance(), formatter);
       }catch (Exception e){
           return ResponseEntity.badRequest().body(new MessageResponse("date de naissance invalide!!"));

       }
        Identificateur identificateur= identificateurDao.findByTypeIdentificateur(signupRequest.getTypeIdentificateur());
        //identificateurDao.save(identificateur);
        Nationalite nationalite =nationaliteDao.findByLibelle(signupRequest.getNationalite());
        //nationaliteDao.save(nationalite);
        Compte compte = new Compte(signupRequest.getLogin(), passwordEncoder.encode(signupRequest.getPassword()),
                new Personne(signupRequest.getNom(), signupRequest.getPrenom(), signupRequest.getMail(),
                        signupRequest.getAdresse(), signupRequest.getTel(),
                        localDate, signupRequest.getLieuDeNaissance(),
                        identificateur,
                        signupRequest.getNumeroIdentificateur(),
                        signupRequest.getSexe(),
                        nationalite));
        Set<String> role = signupRequest.getRole();
        Set<Role> roles=new HashSet<>();
        role.forEach(s -> {
            switch (s){
                case "admin":
                    Role role1 = roleDao.findByRole(ERole.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("erreur role not found!"));
                    roles.add(role1);
                    break;
                case "financier":
                    Role role2 = roleDao.findByRole(ERole.ROLE_FINANCIER)
                            .orElseThrow(() -> new RuntimeException("erreur role not found!"));
                    roles.add(role2);
                    break;
                default:

                    break;
            }
        });
        compte.setRoles(roles);
        compteDao.save(compte);
        return ResponseEntity.ok(new MessageResponse("votre compte est crée avec succée!!"));
    }

}

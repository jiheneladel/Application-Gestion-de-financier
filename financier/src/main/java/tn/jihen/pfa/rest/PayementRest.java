package tn.jihen.pfa.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/pay/")
//@PreAuthorize("hasRole('ADMIN')")
public class PayementRest {

}

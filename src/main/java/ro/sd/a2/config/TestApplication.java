package ro.sd.a2.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


//@RestController
//@CrossOrigin
@Controller
public class TestApplication
{
    //Un get pentru a vedea daca merge aplicatia:
    //Aplicatia basica, pe langa configurare;
    @GetMapping("/")
    public ResponseEntity<String> getStatus()
    {
        return new ResponseEntity<>("Tema 2 Orsan Tudor: Energy App Service is running...", HttpStatus.OK);
    }
}
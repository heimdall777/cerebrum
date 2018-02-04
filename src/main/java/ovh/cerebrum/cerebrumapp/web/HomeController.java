package ovh.cerebrum.cerebrumapp.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ovh.cerebrum.cerebrumapp.domain.Greeting;
import ovh.cerebrum.cerebrumapp.service.GreetingService;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/api")
public class HomeController {

    private String VERSION = "1.0";

    private GreetingService greetingService;

    public HomeController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/greeting")
    public Greeting homeSite() {
        Optional<Greeting> greetingOpt =this.greetingService.findById(1);
        Greeting greeting = greetingOpt.get();
        return greeting;
    }

}

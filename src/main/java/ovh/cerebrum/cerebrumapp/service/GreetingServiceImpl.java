package ovh.cerebrum.cerebrumapp.service;

import org.springframework.stereotype.Service;
import ovh.cerebrum.cerebrumapp.domain.Greeting;
import ovh.cerebrum.cerebrumapp.repository.GreetingRepository;

import java.util.Optional;

@Service
public class GreetingServiceImpl implements GreetingService {

    private GreetingRepository greetingRepository;

    public GreetingServiceImpl(GreetingRepository greetingRepository){
        this.greetingRepository = greetingRepository;
    }

    public Optional<Greeting> findById(long id) {
        return this.greetingRepository.findById(id);
    }

    public Greeting save(Greeting greeting) {
        return this.greetingRepository.save(greeting);
    }

}

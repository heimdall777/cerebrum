package ovh.cerebrum.cerebrumapp.service;

import ovh.cerebrum.cerebrumapp.domain.Greeting;

import java.util.Optional;

public interface GreetingService {

    Optional<Greeting> findById(long id);

    Greeting save(Greeting greeting);

}

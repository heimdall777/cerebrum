package ovh.cerebrum.cerebrumapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ovh.cerebrum.cerebrumapp.domain.Greeting;

@Repository
public interface GreetingRepository extends JpaRepository<Greeting, Long> {
}

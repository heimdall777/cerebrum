package ovh.cerebrum.cerebrumapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ovh.cerebrum.cerebrumapp.domain.DockerImage;
import ovh.cerebrum.cerebrumapp.domain.Greeting;
import ovh.cerebrum.cerebrumapp.service.DockerImageService;
import ovh.cerebrum.cerebrumapp.service.GreetingService;

@Slf4j
@SpringBootApplication
public class CerebrumAppApplication {

    @Autowired
    GreetingService greetingService;
    @Autowired
    DockerImageService dockerImageService;

    public static void main(String[] args) {
        SpringApplication.run(CerebrumAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo() {
        return (String... args) -> {

            greetingService.save(new Greeting("Hello World!"));
            log.info(greetingService.findById(1).toString());

            dockerImageService.findAll().forEach((DockerImage dockerImage) -> log.info(dockerImage.toString()));

        };
    }

}

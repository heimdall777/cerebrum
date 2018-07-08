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

import java.util.Arrays;

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

            dockerImageService.save(new DockerImage("Ubuntu", "16.04"));
            dockerImageService.save(new DockerImage("Ubuntu", "17.10"));
            dockerImageService.save(new DockerImage("Ubuntu", "17.10"));
            dockerImageService.save(new DockerImage("Ubuntu", "16.04", Arrays.asList("Java", "Spring")));
            dockerImageService.save(new DockerImage("Ubuntu", "16.04", Arrays.asList("Java", "Spring")));

            dockerImageService.findAll().forEach((DockerImage dockerImage) -> log.info(dockerImage.toString()));

        };
    }


}

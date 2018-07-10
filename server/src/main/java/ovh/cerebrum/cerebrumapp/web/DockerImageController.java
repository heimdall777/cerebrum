package ovh.cerebrum.cerebrumapp.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ovh.cerebrum.cerebrumapp.domain.DockerImage;
import ovh.cerebrum.cerebrumapp.exception.AlreadyExistException;
import ovh.cerebrum.cerebrumapp.service.DockerImageService;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/dockerimage")
public class DockerImageController {

    private DockerImageService dockerImageService;

    public DockerImageController(DockerImageService dockerImageService) {
        this.dockerImageService = dockerImageService;
    }

    @GetMapping("")
    public List<DockerImage> getAllImages(){
        return this.dockerImageService.findAll();
    }

    @PostMapping("create")
    public ResponseEntity<String> createImage(@RequestBody DockerImage dockerImage) {

        log.info("Adding docker container to repository.");

        if (!isContainerValid(dockerImage)) {
            log.info("Cannot create docker container. Bad request." + dockerImage.toString());
            return new ResponseEntity<String>("Cannot create docker container.", HttpStatus.BAD_REQUEST);
        }

        try {
            dockerImageService.save(dockerImage);
            return new ResponseEntity<String>("Docker container added to repository.", HttpStatus.OK);
        } catch (AlreadyExistException e) {
            log.error("Object already in container repository.", e);
            return new ResponseEntity<String>("Object already in container repository.", HttpStatus.CONFLICT);
        }

    }

    private boolean isContainerValid(DockerImage dockerImage) {

        if ((dockerImage.getOsType() == null) && dockerImage.getOsVersion() == null) {
            return false;
        }

        return true;
    }

}

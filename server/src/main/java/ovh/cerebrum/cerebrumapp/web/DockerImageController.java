package ovh.cerebrum.cerebrumapp.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ovh.cerebrum.cerebrumapp.domain.DockerImage;
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

}

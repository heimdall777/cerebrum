package ovh.cerebrum.cerebrumapp.service;

import org.springframework.stereotype.Service;
import ovh.cerebrum.cerebrumapp.domain.DockerImage;
import ovh.cerebrum.cerebrumapp.repository.DockerImageRepository;

import java.util.List;

@Service
public class DockerImageServiceImpl implements DockerImageService {

    private DockerImageRepository dockerImageRepository;

    public DockerImageServiceImpl(DockerImageRepository dockerImageRepository){
        this.dockerImageRepository = dockerImageRepository;
    }

    public List<DockerImage> findAll() {
        return this.dockerImageRepository.findAll();
    }

    @Override
    public DockerImage save(DockerImage dockerImage) {
        return this.dockerImageRepository.save(dockerImage);
    }

}

package ovh.cerebrum.cerebrumapp.service;

import ovh.cerebrum.cerebrumapp.domain.DockerImage;
import ovh.cerebrum.cerebrumapp.exception.AlreadyExistException;

import java.util.List;

public interface DockerImageService {
    List<DockerImage> findAll();
    DockerImage save(DockerImage dockerImage) throws AlreadyExistException;
}

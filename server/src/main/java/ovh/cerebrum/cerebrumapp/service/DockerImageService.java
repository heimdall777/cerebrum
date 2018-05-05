package ovh.cerebrum.cerebrumapp.service;

import ovh.cerebrum.cerebrumapp.domain.DockerImage;

import java.util.List;

public interface DockerImageService {
    List<DockerImage> findAll();
    DockerImage save(DockerImage dockerImage);
}

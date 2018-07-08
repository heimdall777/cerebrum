package ovh.cerebrum.cerebrumapp.service;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import ovh.cerebrum.cerebrumapp.domain.DockerImage;
import ovh.cerebrum.cerebrumapp.exception.AlreadyExistException;
import ovh.cerebrum.cerebrumapp.repository.DockerImageRepository;
import static org.springframework.data.domain.ExampleMatcher.*;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.*;

import java.util.List;

@Service
public class DockerImageServiceImpl implements DockerImageService {

    private DockerImageRepository dockerImageRepository;

    public DockerImageServiceImpl(DockerImageRepository dockerImageRepository) {
        this.dockerImageRepository = dockerImageRepository;
    }

    public List<DockerImage> findAll() {
        return this.dockerImageRepository.findAll();
    }

    @Override
    public DockerImage save(DockerImage dockerImage) throws AlreadyExistException {

        Example<DockerImage> example = Example.of(new DockerImage(dockerImage.getOsType(), dockerImage.getOsVersion()));

        boolean doesImageExist =

                dockerImageRepository.findAll(example).size() > 0;

        if (doesImageExist) {

            throw new AlreadyExistException();

        } else {

            return this.dockerImageRepository.save(dockerImage);

        }

    }

}

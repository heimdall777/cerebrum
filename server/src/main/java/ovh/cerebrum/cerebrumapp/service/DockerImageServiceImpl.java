package ovh.cerebrum.cerebrumapp.service;

import org.springframework.stereotype.Service;
import ovh.cerebrum.cerebrumapp.domain.DockerImage;
import ovh.cerebrum.cerebrumapp.exception.AlreadyExistException;
import ovh.cerebrum.cerebrumapp.repository.DockerImageRepository;

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

        boolean anyAdditionalSoftware = dockerImage.getAdditionalSoftware() != null;

        boolean doesImageExist = anyAdditionalSoftware ?
                dockerImageRepository.findAllByOsTypeAndOsVersionAndAdditionalSoftwareIn(dockerImage.getOsType(),
                        dockerImage.getOsVersion(),
                        dockerImage.getAdditionalSoftware()).size() > 0 :
                dockerImageRepository.findAllByOsTypeAndOsVersionAndAdditionalSoftwareIsNull(dockerImage.getOsType(),
                        dockerImage.getOsVersion()).size() > 0;

        if (doesImageExist) {
            throw new AlreadyExistException();
        } else {
            return this.dockerImageRepository.save(dockerImage);
        }

    }

    @Override
    public void deleteAll() {
        dockerImageRepository.deleteAll();
    }

}

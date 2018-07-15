package ovh.cerebrum.cerebrumapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ovh.cerebrum.cerebrumapp.domain.DockerImage;

import java.util.List;

public interface DockerImageRepository  extends JpaRepository<DockerImage, Long> {
    List<DockerImage> findAllByOsTypeAndOsVersion(String osType, String osVersion);

    List<DockerImage> findAllByOsTypeAndOsVersionAndAdditionalSoftwareIn(String osType, String osVersion, List<String> additionalSoftware);

    List<DockerImage> findAllByOsTypeAndOsVersionAndAdditionalSoftwareIsNull(String osType, String osVersion);
}

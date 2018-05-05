package ovh.cerebrum.cerebrumapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ovh.cerebrum.cerebrumapp.domain.DockerImage;

public interface DockerImageRepository  extends JpaRepository<DockerImage, Long> {
}

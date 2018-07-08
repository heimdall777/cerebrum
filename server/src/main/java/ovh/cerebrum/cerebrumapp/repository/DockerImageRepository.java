package ovh.cerebrum.cerebrumapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import ovh.cerebrum.cerebrumapp.domain.DockerImage;

import java.util.List;

public interface DockerImageRepository  extends JpaRepository<DockerImage, Long>, QueryByExampleExecutor<DockerImage> {
}

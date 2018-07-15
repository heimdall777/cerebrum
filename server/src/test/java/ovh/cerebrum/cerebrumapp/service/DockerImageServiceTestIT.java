package ovh.cerebrum.cerebrumapp.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ovh.cerebrum.cerebrumapp.CerebrumAppApplication;
import ovh.cerebrum.cerebrumapp.domain.DockerImage;
import ovh.cerebrum.cerebrumapp.exception.AlreadyExistException;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CerebrumAppApplication.class)
@Transactional
public class DockerImageServiceTestIT {

    @Autowired
    private DockerImageService dockerImageService;

    @Before
    public void setUp() throws AlreadyExistException {
        dockerImageService.save(new DockerImage("Ubuntu", "16.04"));
        dockerImageService.save(new DockerImage("Ubuntu", "17.10"));
        dockerImageService.save(new DockerImage("Ubuntu", "16.10", Arrays.asList("Java", "Spring")));
    }

    @After
    public void tearDown() {
        dockerImageService.deleteAll();
    }

    @Test
    public void shouldReturnAllContainers() {

        // given:
        List<DockerImage> allImages = dockerImageService.findAll();

        // when:

        // then:
        assertThat(allImages.size()).isEqualTo(3);

    }

    @Test
    public void onAddNonExistingContainerShouldAddContainerToRepository() throws AlreadyExistException {

        // given:

        // when:
        dockerImageService.save(new DockerImage("Ubuntu", "18.04"));

        // then:
        assertThat(dockerImageService.findAll().size()).isEqualTo(4);

    }

    @Test(expected = AlreadyExistException.class)
    public void onAddExistingContainerShouldThrowException() throws AlreadyExistException {

        // given:
        dockerImageService.save(new DockerImage("Ubuntu", "16.04"));
        // when:

        // then:
    }

    @Test(expected = AlreadyExistException.class)
    public void onAddExistingContainerWithAdditionalSoftwareShouldThrowException() throws AlreadyExistException {

        // given:
        dockerImageService.save(new DockerImage("Ubuntu", "16.10", Arrays.asList("Java", "Spring")));
        // when:

        // then:
    }

}

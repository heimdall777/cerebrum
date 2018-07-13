package ovh.cerebrum.cerebrumapp.web;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ovh.cerebrum.cerebrumapp.domain.DockerImage;
import ovh.cerebrum.cerebrumapp.exception.AlreadyExistException;
import ovh.cerebrum.cerebrumapp.service.DockerImageService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DockerImageControllerTest {

    @Autowired
    private DockerImageService dockerImageService;
    private DockerImageController controller;
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {

        dockerImageService.save(new DockerImage("Ubuntu", "16.04"));
        dockerImageService.save(new DockerImage("Ubuntu", "17.10"));
        dockerImageService.save(new DockerImage("Ubuntu", "16.10", Arrays.asList("Java", "Spring")));

        controller = new DockerImageController(dockerImageService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @After
    public void tearDown() {
        dockerImageService.deleteAll();
    }

    @Test
    public void shouldReturnAllImages() throws Exception {
        //given

        //when
        List<DockerImage> result = controller.getAllImages();
        //then
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    public void shouldReturnBadRequestOnEmptyImage() {
        //given
        DockerImage emptyImage = new DockerImage();
        //when
        ResponseEntity<String> result = controller.createImage(emptyImage);
        //then
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void shouldReturnHttpOKAfterCorrectImage() {
        //given
        DockerImage correctImage = new DockerImage("Ubuntu", "18.04");
        //when
        ResponseEntity<String> result = controller.createImage(correctImage);
        //then
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(dockerImageService.findAll().size()).isEqualTo(4);
    }

    @Test
    public void shouldReturnHttpConflictAfterExistingImage() {
        //given
        DockerImage correctImage = new DockerImage("Ubuntu", "16.04");
        //when
        ResponseEntity<String> result = controller.createImage(correctImage);
        //then
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.CONFLICT);
        assertThat(dockerImageService.findAll().size()).isEqualTo(3);
    }

    @Test
    public void shouldReturnHttpOk() throws Exception {
        //then
        mockMvc.perform(get("/api/dockerimage").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

    }

}

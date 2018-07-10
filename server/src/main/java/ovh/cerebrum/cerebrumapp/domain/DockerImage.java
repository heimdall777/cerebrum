package ovh.cerebrum.cerebrumapp.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "DOCKER_IMAGE")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DockerImage {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    long id;

    private String osType;
    private String osVersion;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> additionalSoftware;

    public DockerImage(String osType, String osVersion) {
        this.osType = osType;
        this.osVersion = osVersion;
    }

    public DockerImage(String osType, String osVersion, List<String> additionalSoftware) {
        this.osType = osType;
        this.osVersion = osVersion;
        this.additionalSoftware = additionalSoftware;
    }

}

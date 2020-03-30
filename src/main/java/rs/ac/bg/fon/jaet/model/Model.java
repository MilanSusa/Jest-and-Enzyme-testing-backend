package rs.ac.bg.fon.jaet.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Model {

    @Id
    @GeneratedValue
    private Long id;
    private String url;
    @OneToMany(mappedBy = "model")
    private List<Inference> inferences = new ArrayList<>();

}

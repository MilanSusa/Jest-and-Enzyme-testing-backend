package rs.ac.bg.fon.jaet.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Model {

    @Id
    @GeneratedValue
    private Long id;
    private String url;
    @OneToMany(mappedBy = "model")
    private List<Inference> inferences = new ArrayList<>();

}

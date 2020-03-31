package rs.ac.bg.fon.jaet.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Payload implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Id
    private Long inferenceId;
    @OneToOne
    @PrimaryKeyJoinColumn(name = "inference_id", referencedColumnName = "id")
    private Inference inference;
    private double size;

}

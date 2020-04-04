package rs.ac.bg.fon.jaet.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import rs.ac.bg.fon.jaet.model.compositekey.InferenceKey;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@IdClass(InferenceKey.class)
public class Inference {

    @Id
    @GeneratedValue
    private Long id;
    @Id
    @ManyToOne
    private Person person;
    @Id
    @ManyToOne
    private Model model;
    @OneToOne
    private Payload payload;
    private String result;

}

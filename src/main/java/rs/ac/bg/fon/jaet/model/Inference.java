package rs.ac.bg.fon.jaet.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
public class Inference implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Id
    @ManyToOne
    private Person person;
    @Id
    @ManyToOne
    private Model model;
    private String result;

}

package rs.ac.bg.fon.jaet.model.compositekey;

import lombok.*;
import rs.ac.bg.fon.jaet.model.Model;
import rs.ac.bg.fon.jaet.model.Person;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class InferenceKey implements Serializable {

    private Long id;
    private Person person;
    private Model model;

}

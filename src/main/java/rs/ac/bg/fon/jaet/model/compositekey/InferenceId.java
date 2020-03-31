package rs.ac.bg.fon.jaet.model.compositekey;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class InferenceId implements Serializable {

    private Long id;
    private Long person;
    private Long model;

}

package rs.ac.bg.fon.jaet.model.compositekey;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class InferenceId implements Serializable {

    private Long id;
    private Long person;
    private Long model;

}

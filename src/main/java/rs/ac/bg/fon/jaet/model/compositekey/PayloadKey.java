package rs.ac.bg.fon.jaet.model.compositekey;

import lombok.*;
import rs.ac.bg.fon.jaet.model.Inference;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PayloadKey implements Serializable {

    private Long id;
    private Inference inference;

}

package rs.ac.bg.fon.jaet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.ac.bg.fon.jaet.model.compositekey.PayloadKey;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@IdClass(PayloadKey.class)
public class Payload {

    @Id
    @GeneratedValue
    private Long id;
    @Id
    @OneToOne
    @JsonIgnore
    private Inference inference;
    private double size;

}

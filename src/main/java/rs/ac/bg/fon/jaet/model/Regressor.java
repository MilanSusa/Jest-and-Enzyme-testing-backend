package rs.ac.bg.fon.jaet.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Regressor extends Model {

    private double meanSquaredError;
    private double rootMeanSquaredError;
    private double meanAbsoluteError;
    private double coefficientOfDetermination;

}

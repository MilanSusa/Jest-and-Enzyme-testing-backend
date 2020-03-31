package rs.ac.bg.fon.jaet.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Classifier extends Model {

    private double accuracy;
    private double precision;
    private double recall;
    private double f1Score;
    private double specificity;
    private double sensitivity;
    private double areaUnderTheCurve;

}

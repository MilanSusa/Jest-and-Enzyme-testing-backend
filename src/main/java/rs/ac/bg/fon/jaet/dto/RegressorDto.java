package rs.ac.bg.fon.jaet.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import rs.ac.bg.fon.jaet.model.Inference;
import rs.ac.bg.fon.jaet.model.Regressor;

import java.util.List;

@Data
@NoArgsConstructor
public class RegressorDto {

    private Long id;
    private String url;
    private double meanSquaredError;
    private double rootMeanSquaredError;
    private double meanAbsoluteError;
    private double coefficientOfDetermination;
    private List<Inference> inferences;

    public RegressorDto(Regressor regressor) {
        id = regressor.getId();
        url = regressor.getUrl();
        meanSquaredError = regressor.getMeanSquaredError();
        rootMeanSquaredError = regressor.getRootMeanSquaredError();
        meanAbsoluteError = regressor.getMeanAbsoluteError();
        coefficientOfDetermination = regressor.getCoefficientOfDetermination();
        inferences = regressor.getInferences();

        breakInferencesCycle();
    }

    private void breakInferencesCycle() {
        inferences.forEach(inference -> {
            inference.setModel(null);
            inference.getPerson().setInferences(null);
        });
    }

}

package rs.ac.bg.fon.jaet.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import rs.ac.bg.fon.jaet.model.Classifier;
import rs.ac.bg.fon.jaet.model.Inference;

import java.util.List;

@Data
@NoArgsConstructor
public class ClassifierDto {

    private Long id;
    private String url;
    private double accuracy;
    private double precision;
    private double recall;
    private double f1Score;
    private double specificity;
    private double sensitivity;
    private double areaUnderTheCurve;
    private List<Inference> inferences;

    public ClassifierDto(Classifier classifier) {
        id = classifier.getId();
        url = classifier.getUrl();
        accuracy = classifier.getAccuracy();
        precision = classifier.getPrecision();
        recall = classifier.getRecall();
        f1Score = classifier.getF1Score();
        specificity = classifier.getSpecificity();
        sensitivity = classifier.getSensitivity();
        areaUnderTheCurve = classifier.getAreaUnderTheCurve();
        inferences = classifier.getInferences();

        breakInferencesCycle();
    }

    private void breakInferencesCycle() {
        inferences.forEach(inference -> {
            inference.setModel(null);
            inference.getPerson().setInferences(null);
        });
    }

}

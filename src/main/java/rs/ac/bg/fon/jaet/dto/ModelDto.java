package rs.ac.bg.fon.jaet.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import rs.ac.bg.fon.jaet.model.Inference;
import rs.ac.bg.fon.jaet.model.Model;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ModelDto {

    private Long id;
    private String url;
    private List<Inference> inferences = new ArrayList<>();

    public ModelDto(Model model) {
        id = model.getId();
        url = model.getUrl();
        inferences = model.getInferences();

        breakInferencesCycle(inferences);
    }

    private void breakInferencesCycle(List<Inference> inferences) {
        inferences.forEach(inference -> {
            inference.setModel(null);
            inference.getPerson().setInferences(null);
        });
    }

}

package rs.ac.bg.fon.jaet.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import rs.ac.bg.fon.jaet.model.Inference;
import rs.ac.bg.fon.jaet.model.Model;
import rs.ac.bg.fon.jaet.model.Payload;
import rs.ac.bg.fon.jaet.model.Person;

@Data
@NoArgsConstructor
public class InferenceDto {

    private Long id;
    private Person person;
    private Model model;
    private Payload payload;
    private String result;

    public InferenceDto(Inference inference) {
        id = inference.getId();
        person = inference.getPerson();
        model = inference.getModel();
        payload = inference.getPayload();
        result = inference.getResult();

        breakPersonCycle();
        breakModelCycle();
    }

    private void breakPersonCycle() {
        person.setInferences(null);
    }

    private void breakModelCycle() {
        model.setInferences(null);
    }

}

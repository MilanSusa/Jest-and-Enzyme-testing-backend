package rs.ac.bg.fon.jaet.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import rs.ac.bg.fon.jaet.model.Inference;
import rs.ac.bg.fon.jaet.model.Person;

import java.util.List;

@Data
@NoArgsConstructor
public class PersonDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<Inference> inferences;

    public PersonDto(Person person) {
        id = person.getId();
        firstName = person.getFirstName();
        lastName = person.getLastName();
        email = person.getEmail();
        inferences = person.getInferences();

        breakInferencesCycle(inferences);
    }

    private void breakInferencesCycle(List<Inference> inferences) {
        inferences.forEach(inference -> {
            inference.setPerson(null);
            inference.getModel().setInferences(null);
        });
    }

}

package rs.ac.bg.fon.jaet.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Model {

    @Id
    @GeneratedValue
    private Long id;
    private String url;
    
}

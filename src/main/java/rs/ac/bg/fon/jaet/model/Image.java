package rs.ac.bg.fon.jaet.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Image extends Payload {

    private String url;

}

package pl.sdaacademy.covidacademyapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StateMetadata {

    private String name;

    private String state;

    private String twitter;

    private String covid19Site;
}

package pl.sdaacademy.covidacademyapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StateCurrentStats {

    private String state;

    private int positive;

    private int recovered;

    private int deathConfirmed;

}

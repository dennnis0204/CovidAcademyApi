package pl.sdaacademy.covidacademyapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StateStats {

    private String state;

    private int positive;

    private int negative;

    private int recovered;

    private int deathConfirmed;

    private LocalDate dateChecked;

}

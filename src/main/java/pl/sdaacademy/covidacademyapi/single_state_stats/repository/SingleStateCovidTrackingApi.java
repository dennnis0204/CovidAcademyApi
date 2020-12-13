package pl.sdaacademy.covidacademyapi.single_state_stats.repository;

import pl.sdaacademy.covidacademyapi.model.StateCurrentStats;

public interface SingleStateCovidTrackingApi {

    StateCurrentStats getStateCurrentStats(String state);
}

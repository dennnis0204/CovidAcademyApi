package pl.sdaacademy.covidacademyapi.states_stats.repository;

import pl.sdaacademy.covidacademyapi.model.StateCurrentStats;

public interface CovidTrackingApi {

    StateCurrentStats[] getAllStatesCurrentStats();
}

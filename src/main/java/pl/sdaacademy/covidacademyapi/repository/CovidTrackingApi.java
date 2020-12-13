package pl.sdaacademy.covidacademyapi.repository;

import pl.sdaacademy.covidacademyapi.model.StateStats;

public interface CovidTrackingApi {

    StateStats[] getAllStatesCurrentStats();

    StateStats getSingleStateStats(String state, String date);
}

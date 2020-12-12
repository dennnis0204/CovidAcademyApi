package pl.sdaacademy.covidacademyapi.states_stats.service;

import org.springframework.stereotype.Service;
import pl.sdaacademy.covidacademyapi.states_stats.repository.CovidTrackingApi;
import pl.sdaacademy.covidacademyapi.states_stats.repository.StateCurrentStats;

@Service
public class StatesStatsService {

    private final CovidTrackingApi covidTrackingApi;

    public StatesStatsService(CovidTrackingApi covidTrackingApi) {
        this.covidTrackingApi = covidTrackingApi;
    }

    public StateCurrentStats[] getAllStatesCurrentStats() {

        return covidTrackingApi.getAllStatesCurrentStats();
    }
}

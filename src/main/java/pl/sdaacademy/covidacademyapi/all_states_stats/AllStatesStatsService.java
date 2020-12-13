package pl.sdaacademy.covidacademyapi.all_states_stats;

import org.springframework.stereotype.Service;
import pl.sdaacademy.covidacademyapi.repository.CovidTrackingApi;
import pl.sdaacademy.covidacademyapi.model.StateStats;

@Service
public class AllStatesStatsService {

    private final CovidTrackingApi covidTrackingApi;

    public AllStatesStatsService(CovidTrackingApi covidTrackingApi) {
        this.covidTrackingApi = covidTrackingApi;
    }

    public StateStats[] getAllStatesCurrentStats() {

        return covidTrackingApi.getAllStatesCurrentStats();
    }
}

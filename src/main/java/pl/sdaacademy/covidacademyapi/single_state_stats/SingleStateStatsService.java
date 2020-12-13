package pl.sdaacademy.covidacademyapi.single_state_stats;

import org.springframework.stereotype.Service;
import pl.sdaacademy.covidacademyapi.model.StateStats;
import pl.sdaacademy.covidacademyapi.repository.CovidTrackingApi;

@Service
public class SingleStateStatsService {

    private final CovidTrackingApi singleStateCovidTrackingApi;


    public SingleStateStatsService(CovidTrackingApi singleStateCovidTrackingApi) {
        this.singleStateCovidTrackingApi = singleStateCovidTrackingApi;
    }

    public StateStats getStateCurrentStats(String state, String date) {
        return singleStateCovidTrackingApi.getSingleStateStats(state, date);
    }
}

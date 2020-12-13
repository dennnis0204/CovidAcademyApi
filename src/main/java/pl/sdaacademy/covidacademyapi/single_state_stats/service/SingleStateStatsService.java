package pl.sdaacademy.covidacademyapi.single_state_stats.service;

import org.springframework.stereotype.Service;
import pl.sdaacademy.covidacademyapi.model.StateCurrentStats;
import pl.sdaacademy.covidacademyapi.single_state_stats.repository.SingleStateCovidTrackingApi;

@Service
public class SingleStateStatsService {

    private final SingleStateCovidTrackingApi singleStateCovidTrackingApi;


    public SingleStateStatsService(SingleStateCovidTrackingApi singleStateCovidTrackingApi) {
        this.singleStateCovidTrackingApi = singleStateCovidTrackingApi;
    }

    public StateCurrentStats getStateCurrentStats(String state) {
        return singleStateCovidTrackingApi.getStateCurrentStats(state);
    }
}

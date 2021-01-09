package pl.sdaacademy.covidacademyapi.service;

import org.springframework.stereotype.Service;
import pl.sdaacademy.covidacademyapi.model.StateStats;
import pl.sdaacademy.covidacademyapi.repository.CovidTrackingApi;

import java.util.HashSet;

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

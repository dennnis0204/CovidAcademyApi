package pl.sdaacademy.covidacademyapi.states_stats.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sdaacademy.covidacademyapi.states_stats.repository.CovidTrackingApiRepository;
import pl.sdaacademy.covidacademyapi.states_stats.repository.StateCurrentStats;

@Service
public class StatesStatsService {

    private final CovidTrackingApiRepository covidTrackingApiRepository;

    @Autowired
    public StatesStatsService(CovidTrackingApiRepository covidTrackingApiRepository) {
        this.covidTrackingApiRepository = covidTrackingApiRepository;
    }

    public StateCurrentStats[] getAllStatesCurrentStats() {

        return covidTrackingApiRepository.getAllStatesCurrentStats();
    }



}

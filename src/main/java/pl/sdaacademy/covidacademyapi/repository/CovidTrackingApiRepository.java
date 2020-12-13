package pl.sdaacademy.covidacademyapi.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import pl.sdaacademy.covidacademyapi.model.StateStats;

@Repository
public class CovidTrackingApiRepository implements CovidTrackingApi {

    @Value("${covidtrackingapi.allstates.url}")
    private String allStateStatsUrl;

    @Value("${covidtrackingapi.singlestate.url}")
    private String singleStateStatsUrlPattern;

    private final RestTemplate restTemplate;

    public CovidTrackingApiRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public StateStats[] getAllStatesCurrentStats() {
        return restTemplate.getForObject(allStateStatsUrl, StateStats[].class);
    }

    @Override
    public StateStats getSingleStateStats(String state, String date) {
        String requestUrl = String.format(singleStateStatsUrlPattern, state, date);

        return restTemplate.getForObject(requestUrl, StateStats.class);
    }
}

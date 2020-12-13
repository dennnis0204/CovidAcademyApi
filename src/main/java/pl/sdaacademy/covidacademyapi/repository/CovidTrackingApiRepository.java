package pl.sdaacademy.covidacademyapi.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import pl.sdaacademy.covidacademyapi.model.StateStats;

@Repository
public class CovidTrackingApiRepository implements CovidTrackingApi {

    private final String ALL_STATES_STATS_URL;

    private final String SINGLE_STATE_STATS_URL_PATTERN;

    private final RestTemplate restTemplate;

    public CovidTrackingApiRepository(
            @Value("${allstatescovidtrackingapi.url}") String url,
            @Value("${singlestatecovidtrackingapi.url}") String urlPattern,
            RestTemplate restTemplate) {
        this.ALL_STATES_STATS_URL = url;
        this.SINGLE_STATE_STATS_URL_PATTERN = urlPattern;
        this.restTemplate = restTemplate;
    }

    @Override
    public StateStats[] getAllStatesCurrentStats() {
        return restTemplate.getForObject(ALL_STATES_STATS_URL, StateStats[].class);
    }

    @Override
    public StateStats getSingleStateStats(String state, String date) {
        String requestUrl = String.format(SINGLE_STATE_STATS_URL_PATTERN, state, date);

        return restTemplate.getForObject(requestUrl, StateStats.class);
    }
}

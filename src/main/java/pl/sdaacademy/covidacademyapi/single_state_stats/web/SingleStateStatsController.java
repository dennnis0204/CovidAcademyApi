package pl.sdaacademy.covidacademyapi.single_state_stats.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sdaacademy.covidacademyapi.model.StateCurrentStats;
import pl.sdaacademy.covidacademyapi.single_state_stats.service.SingleStateStatsService;


@RestController
@RequestMapping("/state")
public class SingleStateStatsController {

    private final SingleStateStatsService singleStateStatsService;

    public SingleStateStatsController(SingleStateStatsService singleStateStatsService) {
        this.singleStateStatsService = singleStateStatsService;
    }

    @GetMapping("/{state}")
    public StateCurrentStats getCurrentStateStats(@PathVariable String state) {
        return singleStateStatsService.getStateCurrentStats(state);
    }
}

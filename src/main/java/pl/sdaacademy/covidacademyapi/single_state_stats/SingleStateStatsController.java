package pl.sdaacademy.covidacademyapi.single_state_stats;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sdaacademy.covidacademyapi.model.StateStats;
import pl.sdaacademy.covidacademyapi.single_state_stats.SingleStateStatsService;


@RestController
@RequestMapping("/state")
public class SingleStateStatsController {

    private final SingleStateStatsService singleStateStatsService;

    public SingleStateStatsController(SingleStateStatsService singleStateStatsService) {
        this.singleStateStatsService = singleStateStatsService;
    }

    @GetMapping("/{state}/{date}")
    public StateStats getStateStatsSpecificDate(@PathVariable String state, @PathVariable String date) {

        return singleStateStatsService.getStateCurrentStats(state, date);
    }

    @GetMapping("/{state}")
    public StateStats getCurrentStateStats(@PathVariable String state) {

        return singleStateStatsService.getStateCurrentStats(state, "current");
    }
}

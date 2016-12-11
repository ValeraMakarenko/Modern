package by.modern.controller;

import by.modern.domain.Voting;
import by.modern.service.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatisticQuestionnaireController {
    @Autowired
    private VotingService votingService;

    @RequestMapping(value = {"/questionnaire/findByLink/{link}"}, method = RequestMethod.GET)
    public Voting findVotingByLinkAndOpenStatus(@PathVariable String link) {
        return votingService.findVotingByLinkAndOpenStatus(link);
    }
}

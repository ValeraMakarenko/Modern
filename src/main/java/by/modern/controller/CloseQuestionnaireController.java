package by.modern.controller;

import by.modern.service.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CloseQuestionnaireController {
    @Autowired
    private VotingService votingService;

    @RequestMapping(value = {"/questionnaire/close/{idVoting}"}, method = RequestMethod.POST)
    public void closeVoting(@PathVariable Long idVoting) {
        votingService.closeVoting(idVoting);
    }
}

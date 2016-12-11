package by.modern.controller;

import by.modern.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExecutionQuestionnaireController {
    @Autowired
    private AnswerService answerService;

    @RequestMapping(value = {"/questionnaire/execution/{idAnswerList}"}, method = RequestMethod.POST)
    public void closeVoting(@PathVariable List<Long> idAnswerList) {
        answerService.updateCount(idAnswerList);
    }
}

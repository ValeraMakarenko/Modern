package by.modern.controller;

import by.modern.dto.QuestionnaireDto;
import by.modern.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateQuestionnaireController {
    @Autowired
    private QuestionnaireService questionnaireService;

    @RequestMapping(value = {"/questionnaire/create"}, method = RequestMethod.POST)
    public void createVoting(QuestionnaireDto questionnaireDto) {
        questionnaireService.saveQuestionnaire(questionnaireDto);
    }
}

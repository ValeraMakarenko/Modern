package by.modern.service.impl;

import by.modern.dto.QuestionnaireDto;
import by.modern.dto.mapper.QuestionnaireMapper;
import by.modern.service.QuestionnaireService;
import by.modern.service.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service("questionnaireService")
@Transactional
public class QuestionnaireServiceImpl implements QuestionnaireService {
    @Autowired
    private VotingService votingService;
    @Autowired
    private QuestionnaireMapper questionnaireMapper;

    @Override
    public void saveQuestionnaire(QuestionnaireDto questionnaireDto) {
        Assert.notNull(questionnaireDto);
        votingService.addVoting(questionnaireMapper.convertQuestionnaireDtoToVoting(questionnaireDto));
    }
}

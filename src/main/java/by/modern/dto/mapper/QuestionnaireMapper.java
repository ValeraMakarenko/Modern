package by.modern.dto.mapper;

import by.modern.domain.Voting;
import by.modern.dto.QuestionnaireDto;

public interface QuestionnaireMapper {
    Voting convertQuestionnaireDtoToVoting(QuestionnaireDto questionnaireDto);
}

package by.modern.dto.mapper.impl;

import by.modern.domain.Answer;
import by.modern.domain.Question;
import by.modern.domain.Voting;
import by.modern.dto.AnswerDto;
import by.modern.dto.QuestionDto;
import by.modern.dto.QuestionnaireDto;
import by.modern.dto.mapper.QuestionnaireMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class QuestionnaireMapperImpl implements QuestionnaireMapper {
    @Override
    public Voting convertQuestionnaireDtoToVoting(QuestionnaireDto questionnaireDto) {
        Voting voting = new Voting();
        voting.setTheme(questionnaireDto.getTheme());
        voting.setQuestionList(convertQuestionDtoListToQuestionList(questionnaireDto.getQuestionList(), voting));
        return voting;
    }

    private Question convertQuestionDtoToQuestion(QuestionDto questionDto, Voting voting) {
        Question question = new Question();
        question.setTextQuestion(questionDto.getTextQuestion());
        question.setVoting(voting);
        question.setAnswerList(convertAnswerDtoListToAnswerList(questionDto.getAnswerList(), question));
        return question;
    }

    private List<Question> convertQuestionDtoListToQuestionList(List<QuestionDto> questionDtoList, Voting voting) {
        return questionDtoList.stream().map(questionDto -> convertQuestionDtoToQuestion(questionDto, voting)).collect(Collectors.toList());
    }

    private Answer convertAnswerDtoToAnswer(AnswerDto answerDto, Question question) {
        Answer answer = new Answer();
        answer.setTextAnswer(answerDto.getTextAnswer());
        answer.setQuestion(question);
        return answer;
    }

    private List<Answer> convertAnswerDtoListToAnswerList(List<AnswerDto> answerDtoList, Question question) {
        return answerDtoList.stream().map(answerDto -> convertAnswerDtoToAnswer(answerDto, question)).collect(Collectors.toList());
    }
}

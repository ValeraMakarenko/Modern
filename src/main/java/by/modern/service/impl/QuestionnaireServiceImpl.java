package by.modern.service.impl;

import by.modern.domain.Answer;
import by.modern.domain.Question;
import by.modern.domain.Status;
import by.modern.domain.Voting;
import by.modern.dto.AnswerDto;
import by.modern.dto.QuestionDto;
import by.modern.dto.QuestionnaireDto;
import by.modern.service.QuestionnaireService;
import by.modern.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QuestionnaireServiceImpl implements QuestionnaireService {
    @Override
    public void saveQuestionnaire(QuestionnaireDto questionnaireDto) {
        Voting voting = convertQuestionnaireDtoToVoting(questionnaireDto);
    }

    private Voting convertQuestionnaireDtoToVoting(QuestionnaireDto questionnaireDto) {
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

    private Voting setExampleDataToVoting() {
        Voting voting = new Voting();


        List<Question> questionList1 = new ArrayList<>();
        Question question1 = new Question();
        question1.setVoting(voting);

        question1.setTextQuestion("text question 1");

        Question question2 = new Question();
        question2.setVoting(voting);

        question2.setTextQuestion("text question 2");

        List<Answer> answerList1 = new ArrayList<>();
        Answer answer1 = new Answer();
        answer1.setQuestion(question1);
        answer1.setTextAnswer("text answer 1");
        Answer answer2 = new Answer();
        answer2.setQuestion(question1);
        answer2.setTextAnswer("text answer 2");

        answerList1.add(answer1);
        answerList1.add(answer2);

        List<Answer> answerList2 = new ArrayList<>();
        Answer answer3 = new Answer();
        answer3.setQuestion(question2);
        answer3.setTextAnswer("text answer 3");
        Answer answer4 = new Answer();
        answer4.setQuestion(question2);
        answer4.setTextAnswer("text answer 4");

        question1.setAnswerList(answerList1);
        question2.setAnswerList(answerList2);

        answerList2.add(answer3);
        answerList2.add(answer4);

        questionList1.add(question1);
        questionList1.add(question2);

        voting.setQuestionList(questionList1);
        return voting;
    }
}

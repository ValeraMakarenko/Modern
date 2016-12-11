package by.modern.service;

import by.modern.domain.Answer;

import java.util.List;

public interface AnswerService {
    List<Answer> addAnswerList(List<Answer> answers);

    void updateCount(List<Long> idAnswerList);
}

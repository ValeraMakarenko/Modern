package by.modern.service.impl;

import by.modern.dao.QuestionDao;
import by.modern.domain.Question;
import by.modern.service.AnswerService;
import by.modern.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("questionService")
@Transactional
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private AnswerService answerService;

    @Override
    public List<Question> addQuestionList(List<Question> questions) {
        for (Question q : questions) {
            questionDao.save(q);
            answerService.addAnswerList(q.getAnswerList());
        }
        return questions;
    }

    @Override
    public void updateQuestionCount() {
        questionDao.updateQuestionCount();
    }
}

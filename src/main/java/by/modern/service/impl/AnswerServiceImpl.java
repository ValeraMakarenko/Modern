package by.modern.service.impl;

import by.modern.dao.AnswerDao;
import by.modern.domain.Answer;
import by.modern.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("answerService")
@Transactional
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private AnswerDao answerDao;

    @Override
    public List<Answer> addAnswerList(List<Answer> answers) {
        for (Answer a : answers) {
            answerDao.save(a);
        }
        return answers;
    }
}

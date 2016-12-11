package by.modern.service.impl;

import by.modern.dao.AnswerDao;
import by.modern.dao.StatusDao;
import by.modern.dao.VotingDao;
import by.modern.domain.Answer;
import by.modern.domain.Question;
import by.modern.domain.Status;
import by.modern.domain.Voting;
import by.modern.service.AnswerService;
import by.modern.service.QuestionService;
import by.modern.service.VotingService;
import by.modern.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service("votingService")
@Transactional
public class VotingServiceImpl implements VotingService {
    @Autowired
    private StatusDao statusDao;
    @Autowired
    private VotingDao votingDao;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private AnswerService answerService;
    @Autowired
    private AnswerDao answerDao;

    @Override
    public Voting getVoting() {
        return addVoting(setExampleDataToVoting());
    }

    @Override
    public Voting addVoting(Voting voting) {
        Voting save = votingDao.save(voting);
        questionService.addQuestionList(voting.getQuestionList());
        answerDao.updateCount(1L);

        sdfads();
        List<Voting> all = votingDao.findAll();
        Voting voting1 = all.get(0);
        Voting votingByLinkAndStatus = findVotingByLinkAndStatus(voting1.getLink(), voting1.getStatus());
        return save;
    }

    private void sdfads() {
        votingDao.closeVoting(1L);
    }

    @Override
    public Voting findVotingByLink(String link) {
        Assert.hasText(link, "Link is empty");
        Voting votingByLink = votingDao.findVotingByLink(link);
        if (1 == votingByLink.getStatus().getIdStatus()) {
            return votingByLink;
        } else {
            return null; //////error!!!!!!!!!!!!!!
            //можно просто вернуть вотинг и в контролле забахать стринг мол иксепшн
        }
    }

    @Override
    public Voting findVotingByLinkAndStatus(String link, Status status) {
        return votingDao.findVotingByLinkAndStatus(link, getOpenStatus());
    }

    @Override
    public void closeVoting(Long idVoting) {
        votingDao.closeVoting(idVoting);
    }

    private Status getOpenStatus() {
        return statusDao.findOne(1L);
    }

    private List<String> getAllLinks() {
        return votingDao.findAllLinks();
    }

    private Voting setExampleDataToVoting() {
        Voting voting = new Voting();

        Status s = statusDao.findOne(1L);
        voting.setStatus(s);
        voting.setTheme("theme");
        voting.setLink(StringUtils.getRandomString(getAllLinks()));

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

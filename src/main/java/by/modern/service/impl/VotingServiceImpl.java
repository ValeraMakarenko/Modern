package by.modern.service.impl;

import by.modern.dao.VotingDao;
import by.modern.domain.Voting;
import by.modern.service.QuestionService;
import by.modern.service.StatusService;
import by.modern.service.VotingService;
import by.modern.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service("votingService")
@Transactional
public class VotingServiceImpl implements VotingService {
    @Autowired
    private StatusService statusService;
    @Autowired
    private VotingDao votingDao;
    @Autowired
    private QuestionService questionService;

    @Override
    public Voting addVoting(Voting voting) {
        voting.setLink(StringUtils.getRandomString(getAllLinks()));
        voting.setStatus(statusService.getOpenStatus());
        Voting save = votingDao.save(voting);
        questionService.addQuestionList(voting.getQuestionList());
        return save;
    }

    @Override
    public Voting findVotingByLinkAndOpenStatus(String link) {
        Assert.hasText(link, "Link is empty");
        return votingDao.findVotingByLinkAndStatus(link, statusService.getOpenStatus());
    }

    @Override
    public void closeVoting(Long idVoting) {
        votingDao.closeVoting(idVoting);
    }

    private List<String> getAllLinks() {
        return votingDao.findAllLinks();
    }
}

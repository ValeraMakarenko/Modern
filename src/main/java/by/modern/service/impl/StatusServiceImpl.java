package by.modern.service.impl;

import by.modern.dao.StatusDao;
import by.modern.domain.Answer;
import by.modern.domain.Question;
import by.modern.domain.Status;
import by.modern.domain.Voting;
import by.modern.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("statusService")
@Transactional
public class StatusServiceImpl implements StatusService {

    @Autowired
    private StatusDao statusDao;

    @Override
    public List<Status> findAllStatuses() {
        return statusDao.findAll();
    }
}

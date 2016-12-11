package by.modern.service.impl;

import by.modern.dao.StatusDao;
import by.modern.domain.Status;
import by.modern.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("statusService")
@Transactional
public class StatusServiceImpl implements StatusService {
    @Autowired
    private StatusDao statusDao;

    @Override
    public Status getOpenStatus() {
        return statusDao.findOne(1L);
    }
}

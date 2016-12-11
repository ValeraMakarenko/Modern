package by.modern.service;

import by.modern.domain.Status;
import by.modern.domain.Voting;

public interface VotingService {
    Voting getVoting();

    Voting addVoting(Voting voting);

    Voting findVotingByLink(String link);

    Voting findVotingByLinkAndStatus(String link, Status status);

    void closeVoting(Long idVoting);
}

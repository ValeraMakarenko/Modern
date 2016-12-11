package by.modern.service;

import by.modern.domain.Voting;

public interface VotingService {
    Voting addVoting(Voting voting);

    Voting findVotingByLinkAndOpenStatus(String link);

    void closeVoting(Long idVoting);
}

package by.modern.service;

import by.modern.domain.Voting;

public interface VotingService {
    Voting getVoting();

    Voting addVoting(Voting voting);

    Voting findVotingByLink(String link);
}

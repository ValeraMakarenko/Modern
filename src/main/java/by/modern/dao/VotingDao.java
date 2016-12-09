package by.modern.dao;

import by.modern.domain.Voting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VotingDao extends JpaRepository<Voting, Long> {
    @Query("SELECT V.link FROM Voting V")
    List<String> findAllLinks();

    Voting findVotingByLink(String link);
}

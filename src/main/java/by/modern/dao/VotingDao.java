package by.modern.dao;

import by.modern.domain.Status;
import by.modern.domain.Voting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VotingDao extends JpaRepository<Voting, Long> {
    @Query("SELECT V.link FROM Voting V")
    List<String> findAllLinks();

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE Voting V SET V.fk_id_status = 2 WHERE V.id_voting = :idVoting", nativeQuery = true)
    void closeVoting(@Param("idVoting") Long idVoting);

    Voting findVotingByLinkAndStatus(String link, Status status);
}

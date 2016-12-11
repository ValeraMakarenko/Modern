package by.modern.dao;

import by.modern.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AnswerDao extends JpaRepository<Answer, Long> {
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE Answer A SET A.count = A.count + 1 WHERE A.id_answer = :idAnswer", nativeQuery = true)
    void updateCount(@Param("idAnswer") Long idAnswer);
}

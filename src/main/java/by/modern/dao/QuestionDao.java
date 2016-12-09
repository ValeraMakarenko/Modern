package by.modern.dao;

import by.modern.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuestionDao extends JpaRepository<Question, Long> {
    //@Query("UPDATE Question Q SET Q.count = Q.count + 1 WHERE Q.idQuestion = 1")
    void updateQuestionCount();
}

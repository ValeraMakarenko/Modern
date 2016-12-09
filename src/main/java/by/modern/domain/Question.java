package by.modern.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@ToString(exclude = "answerList")
public class Question {
    @Id
    @GeneratedValue
    @Column(name = "id_question")
    private Long idQuestion;

    @NonNull
    @Column(name = "text_question")
    private String textQuestion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_voting")
    @JsonIgnore
    private Voting voting;

    @OneToMany(mappedBy = "question")
    private List<Answer> answerList = new ArrayList<>();
}

package by.modern.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Answer {
    @Id
    @GeneratedValue
    @Column(name = "id_answer")
    private Long idAnswer;

    @NonNull
    @Column(name = "text_answer")
    private String textAnswer;

    private Long count;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_question")
    @JsonIgnore
    private Question question;

    @PrePersist
    public void prePersist() {
        if (count == null)
            count = 0L;
    }
}

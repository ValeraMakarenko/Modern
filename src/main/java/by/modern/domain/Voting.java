package by.modern.domain;

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
@ToString(exclude = "questionList")
public class Voting {
    @Id
    @GeneratedValue
    @Column(name = "id_voting")
    private Long idVoting;

    @NonNull
    private String theme;

    @NonNull
    private String link;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_status")
    private Status status;

    @OneToMany(mappedBy = "voting")
    private List<Question> questionList = new ArrayList<>();
}

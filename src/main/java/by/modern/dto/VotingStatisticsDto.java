package by.modern.dto;

import by.modern.domain.Question;
import by.modern.domain.Status;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VotingStatisticsDto {

    private String theme;
    private String link;
    private Status status;
    private List<Question> questions;

    public VotingStatisticsDto() {
        super();
    }
}

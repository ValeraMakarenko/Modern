package by.modern.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuestionDto {
    @NonNull
    private String textQuestion;
    @NonNull
    private List<AnswerDto> answerList;
}

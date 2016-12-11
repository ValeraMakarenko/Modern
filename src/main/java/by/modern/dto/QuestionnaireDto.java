package by.modern.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuestionnaireDto {
    @NonNull
    private String theme;
    @NonNull
    private List<QuestionDto> questionList;
}

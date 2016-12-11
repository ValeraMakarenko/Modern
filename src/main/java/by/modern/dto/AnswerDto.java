package by.modern.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class AnswerDto {
    @NonNull
    private String textAnswer;
}

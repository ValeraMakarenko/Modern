package by.modern.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Status {
    @Id
    @GeneratedValue
    @Column(name = "id_status")
    @JsonIgnore
    private Long idStatus;

    @NonNull
    @Column(name = "name_status")
    private String name;
}

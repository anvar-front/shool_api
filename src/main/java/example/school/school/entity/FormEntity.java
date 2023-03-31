package example.school.school.entity;

import example.school.school.enums.FormEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class FormEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer form;

    @Enumerated(EnumType.STRING)
    private FormEnum prefix;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "form")
    private List<StudentEntity> students = new ArrayList<>();

    public FormEntity(Integer form, FormEnum prefix) {
        this.form = form;
        this.prefix = prefix;
    }
}

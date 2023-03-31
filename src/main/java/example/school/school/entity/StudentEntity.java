package example.school.school.entity;

import example.school.school.enums.GenderEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String name;
    private String lastname;
    private Date datebirth;

    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private RegionEntity region;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "form_id")
    private FormEntity form;

    public StudentEntity(String firstname,
                         String name,
                         String lastname,
                         Date datebirth,
                         GenderEnum gender,
                         RegionEntity region,
                         FormEntity form) {
        this.firstname = firstname;
        this.name = name;
        this.lastname = lastname;
        this.datebirth = datebirth;
        this.gender = gender;
        this.region = region;
        this.form = form;
    }
}

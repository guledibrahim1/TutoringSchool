package org.guledibrahim.schoolms.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

    @ManyToMany
    @JoinTable(name = "student_subject",
            joinColumns = {@JoinColumn(name = "subject_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id", referencedColumnName = "id")})
    private List<Student> enrolledStudents = new ArrayList<>();

    public Subject(Long id, String name, Tutor tutor) {
        this.id = id;
        this.name = name;
        this.tutor = tutor;
    }
}

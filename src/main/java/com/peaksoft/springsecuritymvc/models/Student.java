package com.peaksoft.springsecuritymvc.models;

import com.peaksoft.springsecuritymvc.enams.StudyFormat;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;
import static javax.persistence.CascadeType.PERSIST;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    @Enumerated(EnumType.STRING)
    private StudyFormat studyFormat;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
}

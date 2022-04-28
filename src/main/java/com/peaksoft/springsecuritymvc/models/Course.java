package com.peaksoft.springsecuritymvc.models;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private int duration;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Teacher teacher;

    @Override
    public String toString() {
        return courseName + "\n";
    }
}

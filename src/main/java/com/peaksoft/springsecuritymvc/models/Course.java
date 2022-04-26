package com.peaksoft.springsecuritymvc.models;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    private Company company;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "group_course", joinColumns = @JoinColumn(name = "group_id"),
//            inverseJoinColumns = @JoinColumn(name = "course_id"))
//    private List<Group> groups;

    @OneToOne(mappedBy = "course", cascade = {DETACH, REFRESH, PERSIST, MERGE})
    private Teacher teacher;

    @Override
    public String toString() {
        return courseName + "\n";
    }
}

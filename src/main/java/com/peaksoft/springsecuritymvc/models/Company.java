package com.peaksoft.springsecuritymvc.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String locatedCountry;

//    @OneToMany(mappedBy = "company")
//    private List<Course> courses;

    @Override
    public String toString() {
        return  companyName;
    }
}

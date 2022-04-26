package com.peaksoft.springsecuritymvc.reposiroties;

import com.peaksoft.springsecuritymvc.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
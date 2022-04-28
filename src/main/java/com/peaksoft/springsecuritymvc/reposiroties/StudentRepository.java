package com.peaksoft.springsecuritymvc.reposiroties;

import com.peaksoft.springsecuritymvc.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select s from Student s where upper(s.firstName) like concat('% ', :name, '%') ")
    List<Student> searchStudentByFirstName(@Param("name") String name);
}
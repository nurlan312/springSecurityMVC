package com.peaksoft.springsecuritymvc.services;

import com.peaksoft.springsecuritymvc.models.Student;
import com.peaksoft.springsecuritymvc.reposiroties.GroupRepository;
import com.peaksoft.springsecuritymvc.reposiroties.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;
    private final GroupRepository groupRepository;

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public void saveStudent(Student student) {
        Student student1 = mapToEntity(student);
        repository.save(student1);
    }

    public Student getByIdStudent(Long id) {
        return repository.findById(id).get();
    }

    public void deleteByIdStudent(Long id) {
        repository.deleteById(id);
    }

    public void updateStudent(Student student, Long id) {
        repository.getById(id);
        repository.save(student);
    }

    public Student mapToEntity(Student student) {
        Student student1 = new Student();
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setEmail(student.getEmail());
        student1.setStudyFormat(student.getStudyFormat());
        student1.setGroup(groupRepository.getById(student.getGroup().getId()));
        return student;
    }
}

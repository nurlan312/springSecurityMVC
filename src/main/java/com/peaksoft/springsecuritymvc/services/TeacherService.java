package com.peaksoft.springsecuritymvc.services;

import com.peaksoft.springsecuritymvc.models.Teacher;
import com.peaksoft.springsecuritymvc.reposiroties.CourseRepository;
import com.peaksoft.springsecuritymvc.reposiroties.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository repository;
    private final CourseRepository courseRepository;

    public List<Teacher> getAllTeachers() {
        return repository.findAll();
    }

    public void saveTeacher(Teacher teacher) {
        Teacher teacher1 = mapToEntity(teacher);
        repository.save(teacher1);
    }

    public Teacher getByIdTeacher(Long id) {
        return repository.findById(id).get();
    }

    public void deleteByIdTeacher(Long id) {
        repository.deleteById(id);
    }

    public void updateTeacher(Teacher teacher, Long id) {
        repository.getById(id);
        repository.save(teacher);
    }

    public Teacher mapToEntity(Teacher teacher) {
        Teacher teacher1 = new Teacher();
        teacher1.setFirstName(teacher.getFirstName());
        teacher1.setLastName(teacher.getLastName());
        teacher1.setEmail(teacher.getEmail());
        teacher1.setCourse(courseRepository.getById(teacher.getCourse().getId()));
        return teacher1;
    }
}

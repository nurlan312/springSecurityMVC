package com.peaksoft.springsecuritymvc.controllers;

import com.peaksoft.springsecuritymvc.models.Student;
import com.peaksoft.springsecuritymvc.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("student/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "/student/students";
    }

    @GetMapping("/add-student")
    public String createStudent(Model model) {
        model.addAttribute("student", new Student());
        return "/student/add-student";
    }

    @PostMapping("/save-student")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/student/students";
    }

    @GetMapping("/update-student/{id}")
    public String updateStudent(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getByIdStudent(id));
        return "/student/update-student";
    }

    @PostMapping("/edit-student/{id}")
    public String editStudent(@PathVariable Long id, @ModelAttribute("student") Student student) {
        studentService.updateStudent(student, id);
        return "redirect:/student/students";
    }

    @GetMapping("/delete-student/{id}")
    public String deleteByIdStudent(@PathVariable Long id) {
        studentService.deleteByIdStudent(id);
        return "redirect:/student/students";
    }
}

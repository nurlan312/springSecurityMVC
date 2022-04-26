package com.peaksoft.springsecuritymvc.controllers;

import com.peaksoft.springsecuritymvc.models.Teacher;
import com.peaksoft.springsecuritymvc.services.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("teacher/teachers")
public class TeacherController {

    private final TeacherService teacherService;
    @GetMapping
    public String getAllTeachers(Model model) {
        model.addAttribute("teachers", teacherService.getAllTeachers());
        return "/teacher/teachers";
    }

    @GetMapping("/add-teacher")
    public String addTeacher(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "/teacher/add-teacher";
    }

    @PostMapping("/save-teacher")
    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher) {
        teacherService.saveTeacher(teacher);
        return "redirect:/teacher/teachers";
    }

    @GetMapping("/update-teacher/{id}")
    public String updateTeacher(@PathVariable Long id, Model model) {
        model.addAttribute("teacher", teacherService.getByIdTeacher(id));
        return "/teacher/update-teacher";
    }

    @PostMapping("/edit-teacher/{id}")
    public String editTeacher(@PathVariable Long id, @ModelAttribute("teacher") Teacher teacher) {
        teacherService.updateTeacher(teacher, id);
        return "redirect:/teacher/teachers";
    }

    @GetMapping("/delete-teacher/{id}")
    public String deleteByIdTeacher(@PathVariable Long id) {
        teacherService.deleteByIdTeacher(id);
        return "redirect:/teacher/teachers";
    }
}

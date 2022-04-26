package com.peaksoft.springsecuritymvc.controllers;

import com.peaksoft.springsecuritymvc.models.Course;
import com.peaksoft.springsecuritymvc.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("course/courses")
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public String getAllCourses(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "/course/courses";
    }

    @GetMapping("/add-course")
    public String createCourse(Model model) {
        model.addAttribute("course", new Course());
        return "/course/add-course";
    }

    @PostMapping("/save-course")
    public String saveCourse(@ModelAttribute("course") Course course) {
        courseService.saveCourse(course);
        return "redirect:/course/courses";
    }

    @GetMapping("/update-course/{id}")
    public String updateCourse(@PathVariable Long id, Model model) {
        model.addAttribute("course", courseService.getByIdCourse(id));
        return "/course/update-course";
    }

    @PostMapping("/edit-course/{id}")
    public String editCourse(@PathVariable Long id, @ModelAttribute("course") Course course) {
        courseService.updateCourse(course, id);
        return "redirect:/course/courses";
    }

    @GetMapping("/delete-course/{id}")
    public String deleteByIdCourse(@PathVariable Long id) {
        courseService.deleteByIdCourse(id);
        return "redirect:/course/courses";
    }
}

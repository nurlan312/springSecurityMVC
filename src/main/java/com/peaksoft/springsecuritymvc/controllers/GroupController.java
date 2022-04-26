package com.peaksoft.springsecuritymvc.controllers;

import com.peaksoft.springsecuritymvc.models.Group;
import com.peaksoft.springsecuritymvc.services.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("group/groups")
public class GroupController {

    private final GroupService groupService;

    @GetMapping
    public String getAllGroups(Model model) {
        model.addAttribute("groups", groupService.getAllGroups());
        return "/group/groups";
    }

    @GetMapping("/add-group")
    public String createGroup(Model model) {
        model.addAttribute("group", new Group());
        return "/group/add-group";
    }

    @PostMapping("/save-group")
    public String saveGroup(@ModelAttribute("group") Group group) {
        groupService.saveGroup(group);
        return "redirect:/group/groups";
    }

    @GetMapping("/update-group/{id}")
    public String updateGroup(@PathVariable Long id, Model model) {
        model.addAttribute("group", groupService.getByIdGroup(id));
        return "/group/update-group";
    }

    @PostMapping("/edit-group/{id}")
    public String editGroup(@PathVariable Long id, @ModelAttribute("group") Group group) {
        groupService.updateGroup(group, id);
        return "redirect:/group/groups";
    }

    @GetMapping("/delete-group/{id}")
    public String deleteByIdGroup(@PathVariable Long id) {
        groupService.deleteByIdGroup(id);
        return "redirect:/group/groups";
    }
}

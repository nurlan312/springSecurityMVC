package com.peaksoft.springsecuritymvc.controllers;

import com.peaksoft.springsecuritymvc.models.Company;
import com.peaksoft.springsecuritymvc.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("company/companies")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping
    public String getAllCompanies(Model model) {
        model.addAttribute("companies", companyService.getAllCompanies());
        return "/company/companies";
    }

    @GetMapping("/add-company")
    public String createCompany(Model model) {
        model.addAttribute("company", new Company());
        return "/company/add-company";
    }

    @PostMapping("/save-company")
    public String saveCompany(@ModelAttribute("company") Company company) {
        companyService.saveCompany(company);
        return "redirect:/company/companies";
    }

    @GetMapping("/update-company/{id}")
    public String updateCompany(@PathVariable Long id, Model model) {
        model.addAttribute("company", companyService.getByIdCompany(id));
        return "/company/update-company";
    }

    @PostMapping("/edit-company/{id}")
    public String editCompany(@PathVariable Long id, @ModelAttribute("company") Company company) {
        companyService.updateCompany(company, id);
        return "redirect:/company/companies";
    }

    @GetMapping("/delete-company/{id}")
    public String deleteByIdCompany(@PathVariable Long id) {
        companyService.deleteByIdCompany(id);
        return "redirect:/company/companies";
    }
}

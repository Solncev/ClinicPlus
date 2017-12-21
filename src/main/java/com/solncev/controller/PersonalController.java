package com.solncev.controller;

import com.solncev.model.User;
import com.solncev.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Марат on 21.05.2017.
 */
@Controller
public class PersonalController {
    private final DoctorService doctorService;

    @Autowired
    public PersonalController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @RequestMapping(value = "/specialists")
    public String getAllDoctors(Model model) {
        model.addAttribute("doctors", doctorService.getAll());
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("currentUser", currentUser);
        return "specialists";
    }

    @RequestMapping(value = "/leaderships")
    public String getLeaders(Model model) {
        model.addAttribute("doctors", doctorService.getLeaders());
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("currentUser", currentUser);
        return "leaderships";
    }

    @RequestMapping(value = "/specialist/{id}")
    public String getDoctorPage(Model model, @PathVariable(name = "id") String id) {
        model.addAttribute("doctor", doctorService.getOne(Long.valueOf(id)));
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("currentUser", currentUser);
        return "employee";
    }
}

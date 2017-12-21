package com.solncev.controller;

import com.solncev.service.AppointmentService;
import com.solncev.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by Марат on 21.05.2017.
 */
@Controller
public class AppointmentController {
    private final AppointmentService appointmentService;
    private final DoctorService doctorService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService, DoctorService doctorService) {
        this.appointmentService = appointmentService;
        this.doctorService = doctorService;
    }

    @RequestMapping(value = "/appointment")
    public String getAppointmentPage(Model model) {
        model.addAttribute("doctors", doctorService.getAll());
        return "appointment";
    }

    @RequestMapping(value = "/appointment/add")
    public String addAppointment(@RequestParam Map<String, String> allRequestParam) {
        return "redirect:/home";
    }
}

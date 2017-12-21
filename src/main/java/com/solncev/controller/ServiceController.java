package com.solncev.controller;

import com.solncev.model.User;
import com.solncev.service.DealService;
import com.solncev.service.ServiceService;
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
public class ServiceController {
    private final ServiceService serviceService;
    private final DealService dealService;


    @Autowired
    public ServiceController(ServiceService serviceService, DealService dealService) {
        this.serviceService = serviceService;
        this.dealService = dealService;
    }

    @RequestMapping(value = "/service")
    public String getServices(Model model) {
        model.addAttribute("services", serviceService.getAll());
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("currentUser", currentUser);
        return "service";
    }

    @RequestMapping(value = "/service/{id}")
    public String getServicePage(Model model, @PathVariable(name = "id") String id) {
        model.addAttribute("service", serviceService.getById(Long.valueOf(id)));
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("currentUser", currentUser);
        return "servicePage";
    }

    @RequestMapping(value = "/deals")
    public String getDeals(Model model) {
        model.addAttribute("deals", dealService.getAll());
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("currentUser", currentUser);
        return "deals";
    }
}

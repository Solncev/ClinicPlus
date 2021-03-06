package com.solncev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Марат on 19.04.2017.
 */
@Controller
public class MainController {
//    private final AppointmentService appointmentService;

//    @Autowired
//    public MainController(AppointmentService appointmentService) {
//        this.appointmentService = appointmentService;
//    }

//    @RequestMapping("/home")
//    public String getHome(ModelMap modelMap) {
//        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        modelMap.addAttribute("currentUser", currentUser);
//        modelMap.addAttribute("appointments", appointmentService.getAllByClientId(currentUser.getId()));
//        return "homepage";
//    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String getLogin() {
        return "loginpage";
    }

    @RequestMapping("/")
    public String getSlider() {
        return "slider";
    }
}

package com.solncev.controller;

import com.solncev.model.User;
import com.solncev.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Марат on 28.05.2017.
 */
@Controller
public class AdminController {
    private final UserService userService;
    private final CommentService commentService;
    private final ContactService contactService;
    private final DealService dealService;
    private final DoctorService doctorService;
    private final NewsService newsService;
    private final QuestionService questionService;
    private final RoleService roleService;
    private final ServiceService serviceService;
    private final StaffService staffService;
    private final UserRoleService userRoleService;

    @Autowired
    public AdminController(UserService userService, CommentService commentService, ContactService contactService,
                           DealService dealService, DoctorService doctorService, NewsService newsService,
                           QuestionService questionService, RoleService roleService, ServiceService serviceService,
                           StaffService staffService, UserRoleService userRoleService) {
        this.userService = userService;
        this.commentService = commentService;
        this.contactService = contactService;
        this.dealService = dealService;
        this.doctorService = doctorService;
        this.newsService = newsService;
        this.questionService = questionService;
        this.roleService = roleService;
        this.serviceService = serviceService;
        this.staffService = staffService;
        this.userRoleService = userRoleService;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String getAdminPage(Model model, @RequestParam(name = "model", required = false) String modeltype) {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (modeltype == null) {
            model.addAttribute("currentUser", currentUser);
            model.addAttribute("users", userService.getAll());
            model.addAttribute("comments", commentService.getAll());
            model.addAttribute("contacts", contactService.getAll());
            model.addAttribute("deals", dealService.getAll());
            model.addAttribute("doctors", doctorService.getAll());
            model.addAttribute("news", newsService.getAll());
            model.addAttribute("roles", roleService.getAll());
            model.addAttribute("clients_roles", userRoleService.getAll());
            model.addAttribute("staffs", staffService.getAll());
            model.addAttribute("services", serviceService.getAll());
        } else {
            switch (modeltype) {
                case "users":
                    model.addAttribute("users", userService.getAll());
                    break;
                case "comments":
                    model.addAttribute("comments", commentService.getAll());
                    break;
                case "deals":
                    model.addAttribute("deals", dealService.getAll());
                    break;
                case "doctors":
                    model.addAttribute("doctors", doctorService.getAll());
                    break;
                case "news":
                    model.addAttribute("news", newsService.getAll());
                    break;
                case "roles":
                    model.addAttribute("roles", roleService.getAll());
                    break;
                case "clients_roles":
                    model.addAttribute("clients_roles", userRoleService.getAll());
                    break;
                case "staffs":
                    model.addAttribute("staffs", staffService.getAll());
                    break;
                case "services":
                    model.addAttribute("services", serviceService.getAll());
                    break;
            }
        }
        return "admin";
    }
}

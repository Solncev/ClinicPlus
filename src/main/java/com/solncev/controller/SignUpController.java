package com.solncev.controller;

import com.solncev.aspects.ServiceLogger;
import com.solncev.model.Role;
import com.solncev.model.User;
import com.solncev.model.UserRole;
import com.solncev.service.RoleService;
import com.solncev.service.UserRoleService;
import com.solncev.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by Марат on 19.04.2017.
 */
@Controller
public class SignUpController {
    private static Logger logger = Logger.getLogger(SignUpController.class);
    private static final PasswordEncoder encoder = new BCryptPasswordEncoder();
    private final UserService userService;
    private final RoleService roleService;
    private final UserRoleService userRoleService;
    Pattern name = Pattern.compile("^\\D+$");
    Pattern mobile = Pattern.compile("^8\\d{10}$");

    @Autowired
    public SignUpController(UserService userService, RoleService roleService, UserRoleService userRoleService) {
        this.userService = userService;
        this.roleService = roleService;
        this.userRoleService = userRoleService;
    }

    @RequestMapping(value = "registration", method = RequestMethod.GET)
    public String getSignUp() {
        return "registrationpage";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String SignUp(@RequestParam Map<String, String> allRequestParams, Model model) {
        User user = new User();
        String login = allRequestParams.get("login");
        String password = allRequestParams.get("password");
        String passwordConfirmation = allRequestParams.get("password2");
        if (login != null && !login.equals("") && userService.getUser(login) == null) {
            user.setLogin(login);
        } else {
            return "redirect:/registration";
        }
        if (password != null && !password.equals("") && passwordConfirmation != null &&
                !passwordConfirmation.equals("") && password.equals(passwordConfirmation)) {
            user.setPassword(encoder.encode(password));
        } else {
            return "redirect:/registration";
        }
        user.setName(allRequestParams.get("firstname"));
        user.setSurname(allRequestParams.get("surname"));
        user.setPatronymic(allRequestParams.get("patronymic"));
        user.setMobileNumber(allRequestParams.get("mobilenumber"));
        user.setOMSNumber(allRequestParams.get("omsnumber"));
        user.setGender(allRequestParams.get("gender"));

        Role role = roleService.getOne((long) 2);
        UserRole userRole = new UserRole();
        userRole.setRole(role);
        userRole.setUser(user);
        userService.add(user);
        userRoleService.add(userRole);
        logger.info("user was logged up");
        return "redirect:/login";
    }
}

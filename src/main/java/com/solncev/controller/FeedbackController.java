package com.solncev.controller;

import com.solncev.aspects.ServiceLogger;
import com.solncev.model.Comment;
import com.solncev.model.User;
import com.solncev.service.CommentService;
import com.solncev.service.ContactService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.Map;

/**
 * Created by Марат on 21.05.2017.
 */
@Controller
public class FeedbackController {
    private static Logger logger = Logger.getLogger(FeedbackController.class);
    private final ContactService contactService;
    private final CommentService commentService;

    @Autowired
    public FeedbackController(ContactService contactService, CommentService commentService) {
        this.contactService = contactService;
        this.commentService = commentService;
    }

    @RequestMapping(value = "/contact")
    public String getContacts(Model model) {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("contacts", contactService.getAll());
        return "contacts";
    }

    @RequestMapping(value = "/comment")
    public String getComments(Model model) {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("comments", commentService.getAll());
        return "comments";
    }

    @RequestMapping(value = "/comment/send", method = RequestMethod.POST)
    public String addComment(@RequestParam Map<String, String> allRequestParams, Model model) {
        Comment comment = new Comment();
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("currentUser", currentUser);
        comment.setDate(new Date(System.currentTimeMillis()));
        comment.setUser(currentUser);
        comment.setText(allRequestParams.get("comment"));
        commentService.add(comment);
        logger.info("comment was added");
        return "redirect:/comment";
    }
}

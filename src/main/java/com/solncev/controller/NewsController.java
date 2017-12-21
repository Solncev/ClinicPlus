package com.solncev.controller;

import com.solncev.model.News;
import com.solncev.model.User;
import com.solncev.service.NewsService;
import com.solncev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Марат on 20.05.2017.
 */
@Controller
public class NewsController {
    private final NewsService newsService;
    private final UserService userService;

    @Autowired
    public NewsController(NewsService newsService, UserService userService) {
        this.newsService = newsService;
        this.userService = userService;
    }

    @RequestMapping(value = "/news")
    public String getAllNews(Model model) {
        model.addAttribute("newsList", newsService.getAll());
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("currentUser", currentUser);
        return "news";
    }

    @RequestMapping(value = "/news/{id}")
    public String getNews(Model model, @PathVariable(name = "id") String id) {
        News news = newsService.getOne(Long.valueOf(id));
        model.addAttribute("news", news);
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("currentUser", currentUser);
        return "newsPage";
    }
}

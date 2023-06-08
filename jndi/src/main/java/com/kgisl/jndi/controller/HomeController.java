package com.kgisl.jndi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.kgisl.jndi.dao.UserDAO;
import com.kgisl.jndi.model.User;

import java.util.List;
@ComponentScan
@Controller
public class HomeController {
static {
    System.out.println("helooooo");
}
    private final UserDAO userDAO;

    @Autowired
    public HomeController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping("/")
    public String listUsers(Model model) {
        System.out.println("index called");
        List<User> users = userDAO.list();
        for(User u:users) {
            System.out.println(u.getId()+""+u.getUsername());
        }
        model.addAttribute("users", users);
        return "user";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") int id, Model model) {
        User user = userDAO.getById(id);
        model.addAttribute("user", user);
        return "user-details";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        
        model.addAttribute("user", new User());
        return "add-user";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") User user) {
        System.out.println("addd called");
        userDAO.create(user);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        System.out.println("edit called");
        User user = userDAO.getById(id);
        model.addAttribute("user", user);
        return "edit-user";
    }

    @PostMapping("/edit/{id}")
    public String updateUser(@PathVariable("id") int id, @ModelAttribute("user") User user) {
        user.setId(id);
        userDAO.update(user);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        System.out.println("delete called");
        userDAO.delete(id);
        return "redirect:/";
    }
}
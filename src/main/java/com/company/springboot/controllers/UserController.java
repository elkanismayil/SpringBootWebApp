package com.company.springboot.controllers;

import com.company.springboot.entity.User;
import com.company.springboot.repository.UserRepository;
import com.company.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Qualifier("userRepository")
    @Autowired
    private UserRepository repository;

    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/register")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "signup_form";
    }

    @PostMapping("/process-register")
    public String processRegistration(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userService.saveUser(user);
        return "register_success";
    }

    @GetMapping("/list-users")
    public String viewUserList(Model model) {

        return listByPage(model, 1);
    }

    @GetMapping("page/{pageNumber}")
    public String listByPage(Model model, @PathVariable(name = "pageNumber") int currentPage) {
        Page<User> page = userService.getUsers(currentPage);
        long totalRows = page.getTotalElements();
        int totalPages = page.getTotalPages();
        List<User> userList = page.getContent();
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalRows", totalRows);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("listUser", userList);
        return "users";
    }

//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }

    @GetMapping("/home")
    public String showHomePage() {
        return "home";
    }

    @GetMapping("/signup")
    public String toSignUp() {
        return "redirect:/register";
    }

//    @GetMapping("/update")
//    public String updatePage() {
//        return "update";
//    }

    @RequestMapping("/get-one")
    @ResponseBody
    public User getOne(Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/redirect")
    public String redirectMethod() {
        return "update";
    }

    @RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.GET})
    public String update(User user, Long id) {
        User newUser = userService.getUserById(id);
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        userService.updateUser(newUser);
        return "redirect:/list-users";
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id) {
        userService.deleteUserById(id);
        return "redirect:/list-users";
    }


//    @GetMapping("/list-users/{pageNo}")
//    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
//        int pageSize = 5;
//        Page<User> page = userService.findPaginated(pageNo, pageSize);
//        List<User> userList = page.getContent();
//        model.addAttribute("currentPage", pageNo);
//        model.addAttribute("totalPages", page.getTotalPages());
//        model.addAttribute("totalItems", page.getTotalElements());
//        model.addAttribute("userList", userList);
//        return "users";
//    }
//
//    @GetMapping("/login")
//    public String customLoginPage(){
//        return "login";
//    }
}

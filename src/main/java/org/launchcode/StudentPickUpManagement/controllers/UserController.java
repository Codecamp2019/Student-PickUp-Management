package org.launchcode.StudentPickUpManagement.controllers;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.launchcode.StudentPickUpManagement.models.LoginModel;
import org.launchcode.StudentPickUpManagement.models.User;
import org.launchcode.StudentPickUpManagement.models.UserModel;
import org.launchcode.StudentPickUpManagement.models.data.UserDao;
import org.launchcode.StudentPickUpManagement.services.LoginService;
import org.launchcode.StudentPickUpManagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String login(Model model) {

        model.addAttribute("title", "Teacher Sign In");
        model.addAttribute(new LoginModel());
        return "login";
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    public String login(@ModelAttribute @Valid LoginModel newuser, Errors errors, Model model) throws Exception {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Teacher Sign In");
            return "login";
        }

        //if valid user return to main page with welcome message

        //initialize login service to get authenticated user
       if (loginService.validateUser(newuser))
 {
            model.addAttribute("userName", "Welcome " + newuser.getUsername() + "");

            return "mainpage";
        }
// if invalid user or wrong password redirect him to login page with invalidcredentials prompt
        model.addAttribute("login", "Invalid Credentials ");
        newuser.setPassword("");
        return "login";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new UserModel());
        model.addAttribute("title", "Teacher Registration page: ");
        return "registration";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)

    public String add(@ModelAttribute @Valid UserModel newuser, Errors errors, Model model) throws Exception {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Teacher Registration page: ");
            return "registration";
        }
        userService.createUser(newuser);
        model.addAttribute("userName", "Welcome " + newuser.getUsername() + "");
        return "mainpage";
    }
}
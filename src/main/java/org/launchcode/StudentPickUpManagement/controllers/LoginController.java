package org.launchcode.StudentPickUpManagement.controllers;
import org.launchcode.StudentPickUpManagement.models.data.StudentDao;
import org.launchcode.StudentPickUpManagement.models.LoginModel;
import org.launchcode.StudentPickUpManagement.models.data.UserDao;
import org.launchcode.StudentPickUpManagement.services.LoginService;
import org.launchcode.StudentPickUpManagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@SessionAttributes("username")
@RequestMapping("user")
public class LoginController {

        @Autowired
        private UserDao userDao;
    @Autowired
    private StudentDao studentDao;

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
        public String login(@ModelAttribute @Valid LoginModel newuser, Errors errors, Model model, HttpSession session) throws Exception {

            if (errors.hasErrors()) {
                model.addAttribute("title", "Teacher Sign In");
                return "login";
            }

            //if valid user return to main page with welcome message

            //initialize login service to get authenticated user
            if (loginService.validateUser(newuser))
                {
                model.addAttribute("username", "Welcome " + newuser.getUsername() + "");
                    model.addAttribute("students1", studentDao.findAllBypickUpType("AFTERCARE"));
                    model.addAttribute("students2", studentDao.findAllBypickUpType("BUS_LINE"));
                    model.addAttribute("students3", studentDao.findAllBypickUpType("CARLINE"));
                    model.addAttribute("students4", studentDao.findAllBypickUpType("WALKERS"));

//                    model.addAttribute("students", studentDao.findAll());
                return "mainpage";
            }
// if invalid user or wrong password redirect him to login page with invalidcredentials prompt
            model.addAttribute("login", "Invalid Credentials ");
            newuser.setPassword("");
            return "login";
        }
}

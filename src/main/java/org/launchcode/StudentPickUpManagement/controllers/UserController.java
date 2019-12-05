package org.launchcode.StudentPickUpManagement.controllers;
import org.launchcode.StudentPickUpManagement.models.Entity.User;
import org.launchcode.StudentPickUpManagement.models.StudentModel;
import org.launchcode.StudentPickUpManagement.models.UserModel;
import org.launchcode.StudentPickUpManagement.models.data.StudentDao;
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
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;


@Controller
@SessionAttributes("username")
@RequestMapping("adduser")

public class UserController
{
//        extends AbstractController {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private StudentDao studentDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new UserModel());
        model.addAttribute("username","");
        model.addAttribute("title", "Teacher Registration page: ");
        return "registration";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)

    public String add(@ModelAttribute @Valid UserModel newuser, Errors errors, Model model, HttpServletRequest request) throws Exception {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Teacher Registration page: ");
            return "registration";
        }
//        User existingUser = userDao.findByUsername(newuser.getUsername());
//        if (existingUser != null) {
//            errors.rejectValue("username", "username.alreadyexists", "A user with that username already exists");
//            return "registration";
//        }
        userService.createUser(newuser);
        //User newuser1 = userDao.findByUsername(newuser.getUsername());
       // setUserInSession(request.getSession(), newuser1);
        model.addAttribute("username", "Welcome " + newuser.getUsername() + "");
        model.addAttribute("students", studentDao.findAll());
        return "mainpage";
    }
    @RequestMapping(value = "/pickUpList", method = RequestMethod.GET)
    public String pickup(Model model) {
        model.addAttribute(new StudentModel());
        model.addAttribute("students", studentDao.findAll());
        return "mainpage";

    }
   }
package org.launchcode.StudentPickUpManagement.controllers;

import org.launchcode.StudentPickUpManagement.models.Entity.Student;
import org.launchcode.StudentPickUpManagement.models.Entity.User;
import org.launchcode.StudentPickUpManagement.models.StudentModel;
import org.launchcode.StudentPickUpManagement.models.data.StudentDao;
import org.launchcode.StudentPickUpManagement.models.data.UserDao;
import org.launchcode.StudentPickUpManagement.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@SessionAttributes("username")
@RequestMapping("addstudent")

public class StudentController {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new StudentModel());
        model.addAttribute("title", "Add Student Page:");
        return "student";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)

    public String add(@ModelAttribute @Valid StudentModel newstudent, Errors errors, Model model) throws Exception {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Student page: ");
            return "student";
        }
        //create userid
//        User user = userDao.findById(21);
//        System.out.println("User..."+user.getEmail());
        studentService.createStudent(newstudent);
        model.addAttribute("students", studentDao.findAll());
        return "mainpage";
    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model) {
        model.addAttribute("username", "");
        return "login";
    }
        @RequestMapping(value = "/eachstudent", method = RequestMethod.GET)
    public String eachstudent(Model model) {
        model.addAttribute("title", "Update Student Page");
        //find student details by id and update the pickup type
        return "updatestudent";
    }
}

//
//
//    @RequestMapping(value = "add", method = RequestMethod.GET)
//    public String displayAddStudentForm(Model model) {
//        model.addAttribute("title", "Add Student");
//        model.addAttribute(new Student());
//        model.addAttribute("categories", studentDao.findAll());
//        return "cheese/add";
//    }
//
//    @RequestMapping(value = "add", method = RequestMethod.POST)
//    public String processAddStudentForm(@ModelAttribute  @Valid Student newStudent,
//                                       Errors errors,
//                                       @RequestParam int categoryId,
//                                       Model model) {
//
//        if (errors.hasErrors()) {
//            model.addAttribute("title", "Add Student");
//            return "cheese/add";
//        }
//
//        User user1 = userDao.findById(categoryId);
//        newStudent.setUser(user1);
//        studentDao.save(newStudent);
//        return "redirect:";
//    }}
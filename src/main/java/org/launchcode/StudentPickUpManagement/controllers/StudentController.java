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
        studentService.createStudent(newstudent);
        model.addAttribute("students", studentDao.findAll());
        //model.addAttribute("students", studentDao.findByColumnandValue(newstudent.getPickUpType(),"BUS_LINE"));
        return "mainpage";
    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model) {
        model.addAttribute("username", "Thanku");
        return "login";
    }
           @RequestMapping(value = "/eachstudent/{studentId}", method = RequestMethod.GET)
    public String eachstudent(Model model, @PathVariable int studentId) {
                 model.addAttribute("title", "Update Student Page");
                 StudentModel studentModel = new StudentModel();

        //find student details by id and update the pickup type
               Student student = studentDao.findById(studentId).get();

               model.addAttribute("student", student);
              return "updatestudent";
    }
    @RequestMapping(value = "/eachstudent/{studentId}", method = RequestMethod.POST)
    public String eachstudent(Model model, @ModelAttribute Student student, @PathVariable int studentId) throws Exception{
        Student student1 = studentDao.findById(studentId).get();
        student1.setPickUpType(student.getPickUpType());
        studentDao.save(student1);
        model.addAttribute("students", studentDao.findAll());
    return "mainpage";
    }
}

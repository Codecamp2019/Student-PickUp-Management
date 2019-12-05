//package org.launchcode.StudentPickUpManagement.controllers;
//
//import org.launchcode.StudentPickUpManagement.models.Entity.User;
//import org.launchcode.StudentPickUpManagement.models.UserModel;
//import org.launchcode.StudentPickUpManagement.models.data.UserDao;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.ModelAttribute;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import javax.validation.Valid;
//
//public class AbstractController {
//
//@Autowired
//    UserDao userDao;
//
//    public static final String userSessionKey = "user_id";
//
//    protected User getUserFromSession(HttpSession session) {
//        Integer userId = (Integer) session.getAttribute(userSessionKey);
//        return userId == null ? null : userDao.findById(userId).get();
//    }
//
//    protected void setUserInSession(HttpSession session, @Valid User user) {
//        session.setAttribute(userSessionKey, user.getUser_id());
//    }
//
//    @ModelAttribute("userId")
//    public Integer getUserIdFromSession(HttpServletRequest request) {
//        return (Integer) request.getSession().getAttribute(userSessionKey);
//    }
//
//}

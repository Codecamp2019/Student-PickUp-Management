package org.launchcode.StudentPickUpManagement.services;

import org.launchcode.StudentPickUpManagement.models.LoginModel;
import org.launchcode.StudentPickUpManagement.models.Entity.User;
import org.launchcode.StudentPickUpManagement.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    UserDao userDao;
    @Autowired
    UserService userService;

    public boolean validateUser(LoginModel newuser) throws Exception {
        User userEntity = userDao.findByUsername(newuser.getUsername());
        if (userEntity != null && userEntity.getUsername().equalsIgnoreCase(newuser.getUsername()) &&
                userService.check(newuser.getPassword(),userEntity.getPassword()))
        {
            return (true) ;          }

        return (false);
    }
}
package org.launchcode.StudentPickUpManagement.models;


import org.springframework.beans.BeanUtils;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Target({ElementType.TYPE})
//@Retention(RetentionPolicy.RUNTIME)
//@Constraint(validatedBy = FieldMatchValidator.class)
//@FieldMatch(first = "password", second = "verifypassword", message = "Passwords are not equal.")
public class UserModel{
        @NotNull
        private String firstname;
        @NotNull
        private String lastname;
        @Email
        private String email;
        @NotNull
        @Size(min = 5, max = 20)
        private String username;
        @NotNull
        @Size(min = 6, max = 20)
        private String password;
        @NotNull(message = "password and verify doesnot match")
        private String verifypassword;
        private String userType;

        private char grade;

        @NotNull
        private String AccessId;


        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

    public String getVerifypassword() {
            return verifypassword;
    }

    public void setVerifypassword(String verifypassword) {
            verifypassword=checkPassword(verifypassword);
        this.verifypassword = verifypassword;
    }
    private String checkPassword(String verifypassword) {
        if (verifypassword != null
                && !password.equals(verifypassword)) {
            return(verifypassword = null);
        }
        return verifypassword;
    }

    public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }


    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    public String getAccessId() {
        return AccessId;
    }


    public void setAccessId(String accessId) {
            AccessId = accessId;
        }
    }


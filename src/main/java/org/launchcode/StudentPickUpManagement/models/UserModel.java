package org.launchcode.StudentPickUpManagement.models;


import org.springframework.beans.BeanUtils;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
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
        @Size(min = 5, max = 15)
        private String username;
        @NotNull
        @Size(min = 6, max = 15)
        private String password;
        @NotNull

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
        this.verifypassword = verifypassword;
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

//
//
//public class FieldMatchValidator implements ConstraintValidator<UserModel, Object> {
//
//    private String firstFieldName;
//    private String secondFieldName;
//
//    @Override
//    public void initialize(final UserModel constraintAnnotation) {
//        firstFieldName = constraintAnnotation.first();
//        secondFieldName = constraintAnnotation.second();
//    }
//
//    @Override
//    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
//        try {
//            final Object firstObj = BeanUtils.getProperty(value, firstFieldName);
//            final Object secondObj = BeanUtils.getProperty(value, secondFieldName);
//
//            boolean isValid = firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
//
//            if (!isValid) {
//                context.disableDefaultConstraintViolation();
//                context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate()).addNode(secondFieldName).addConstraintViolation();
//            }
//
//            return isValid;
//        }
//        catch (final Exception ignore) {
//            // ignore
//        }
//        return true;
//    }
//}
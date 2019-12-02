package org.launchcode.StudentPickUpManagement.services;

import org.launchcode.StudentPickUpManagement.models.Entity.Student;
import org.launchcode.StudentPickUpManagement.models.StudentModel;
import org.launchcode.StudentPickUpManagement.models.data.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentDao studentDao;

    public void createStudent(StudentModel studentModel) throws Exception {
        Student newStudent = buildstudententity(studentModel);
        studentDao.save(newStudent);
    }

    private Student buildstudententity(StudentModel studentModel) throws Exception {
        Student studentEnt = new Student();
        studentEnt.setStudentFirstName(studentModel.getStudentFirstName());
        studentEnt.setStudentLastName(studentModel.getStudentLastName());
        studentEnt.setParentFirstName(studentModel.getParentFirstName());
        studentEnt.setParentLastName(studentModel.getParentLastName());
        studentEnt.setPickUpType(studentModel.getPickUpType());
        return studentEnt;
    }
}
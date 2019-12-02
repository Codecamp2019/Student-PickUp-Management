package org.launchcode.StudentPickUpManagement.models.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
public class Student {
    @Id
    @GeneratedValue
    private int student_id;
    @NotNull
    @Size(min=3,max=20)
    private String studentFirstName;
    @NotNull
    @Size(min=3,max=20)
    private String studentLastName;
    @NotNull
    @Size(min=3,max=20)
        private String parentFirstName;
    @NotNull
    @Size(min=3,max=20)
    private String parentLastName;
    @NotNull
    private String pickUpType;
@ManyToOne
private User user;

    public Student() {
    }
    public Student(String sfn,String sln, String pfn, String pln){
        studentFirstName = sfn;
        studentLastName = sln;
        parentFirstName=pfn;
        parentLastName=pln;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getParentFirstName() {
        return parentFirstName;
    }

    public void setParentFirstName(String parentFirstName) {
        this.parentFirstName = parentFirstName;
    }

    public String getParentLastName() {
        return parentLastName;
    }

    public void setParentLastName(String parentLastName) {
        this.parentLastName = parentLastName;
    }

    public String getPickUpType() {
        return pickUpType;
    }

    public void setPickUpType(String pickUpType) {
        this.pickUpType = pickUpType;
    }
}

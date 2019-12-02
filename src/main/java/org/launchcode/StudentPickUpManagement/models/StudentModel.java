package org.launchcode.StudentPickUpManagement.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class StudentModel {
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

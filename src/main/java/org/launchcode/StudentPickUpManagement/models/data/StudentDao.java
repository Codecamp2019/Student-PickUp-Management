package org.launchcode.StudentPickUpManagement.models.data;

import org.launchcode.StudentPickUpManagement.models.Entity.Student;
import org.launchcode.StudentPickUpManagement.models.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface StudentDao extends CrudRepository<Student,Integer> {
    //public Student findByName(String name);
    //public Student findById(int Id);
public List<Student> findAllBypickUpType(String pickUpType);
          }



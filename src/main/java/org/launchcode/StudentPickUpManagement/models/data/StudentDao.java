package org.launchcode.StudentPickUpManagement.models.data;

import org.launchcode.StudentPickUpManagement.models.Entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
@Repository
@Transactional
public interface StudentDao extends CrudRepository<Student,Integer> {

          }



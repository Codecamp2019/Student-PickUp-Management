package org.launchcode.StudentPickUpManagement.models.data;
import org.launchcode.StudentPickUpManagement.models.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserDao extends CrudRepository<User,Integer>{

    public User findByUsername(String username);
    public User findById(int userId);
   }

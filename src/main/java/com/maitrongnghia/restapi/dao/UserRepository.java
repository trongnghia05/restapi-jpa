package com.maitrongnghia.restapi.dao;

import com.maitrongnghia.restapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findUserByRole(Integer role);
    List<User> findAll();
    List<User> deleteUserById(Integer id);

}

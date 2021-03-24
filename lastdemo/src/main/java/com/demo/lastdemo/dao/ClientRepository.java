package com.demo.lastdemo.dao;


import com.demo.lastdemo.vo.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<UserTable,String> {
    //id 는 pk의 형식

    Optional<UserTable> findByUsername(String username);
    UserTable getOne(String username);
//    Optional<UserTable> findByUsernameAnduAndUserpwd(String username, String userpwd);

}

package com.demo.lastdemo.dao;


import com.demo.lastdemo.vo.UserTable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends CrudRepository<UserTable,String> {
    //id 는 pk의 형식

    Optional<UserTable> findByUsername(String username);

//    Optional<UserTable> findByUsernameAnduAndUserpwd(String username, String userpwd);

}

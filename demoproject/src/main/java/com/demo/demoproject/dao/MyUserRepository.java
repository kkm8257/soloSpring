package com.demo.demoproject.dao;

import com.demo.demoproject.MyUser.MyUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MyUserRepository extends CrudRepository<MyUser,Integer> {

    List<MyUser> findAllByIdx(int idx);

}

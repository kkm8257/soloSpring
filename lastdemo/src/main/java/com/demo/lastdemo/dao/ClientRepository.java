package com.demo.lastdemo.dao;


import com.demo.lastdemo.vo.ClientVO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<ClientVO,String> {
    //id 는 pk의 형식

    ClientVO findByUsername(String username);

}

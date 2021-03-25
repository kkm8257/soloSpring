package com.demo.lastdemo.dao;


import com.demo.lastdemo.vo.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client,String> {
    //id 는 pk의 형식

    Optional<Client> findByClientEmail(String email);


}

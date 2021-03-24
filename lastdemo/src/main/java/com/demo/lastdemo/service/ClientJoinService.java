package com.demo.lastdemo.service;

import com.demo.lastdemo.dao.ClientRepository;
import com.demo.lastdemo.vo.UserTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientJoinService {

    @Autowired
    ClientRepository clientRepository;


    public UserTable joinClient(UserTable clientVO) {
       return clientRepository.save(clientVO);
    }
}

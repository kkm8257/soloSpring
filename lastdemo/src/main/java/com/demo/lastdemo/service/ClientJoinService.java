package com.demo.lastdemo.service;

import com.demo.lastdemo.dao.ClientRepository;
import com.demo.lastdemo.vo.UserTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClientJoinService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public UserTable joinClient(UserTable clientVO) {

        clientVO.setUserpwd(passwordEncoder.encode(clientVO.getUserpwd()));  //평문 암호화

       return clientRepository.save(clientVO);
    }
}

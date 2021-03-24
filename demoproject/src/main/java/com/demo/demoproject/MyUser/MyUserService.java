package com.demo.demoproject.MyUser;


import com.demo.demoproject.dao.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserService implements UserDetailsService {

    @Autowired
    private MyUserRepository myUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String idx) throws UsernameNotFoundException {

        int myIdx=Integer.parseInt(idx);

        MyUser myUser = (MyUser) myUserRepository.findAllByIdx(myIdx);

        return null;
    }
}

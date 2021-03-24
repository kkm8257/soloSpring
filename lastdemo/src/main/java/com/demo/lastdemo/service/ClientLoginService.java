package com.demo.lastdemo.service;


import com.demo.lastdemo.dao.ClientRepository;
import com.demo.lastdemo.vo.UserTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientLoginService implements UserDetailsService {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("login try..");
        List<GrantedAuthority> authorities=new ArrayList<>();




//        Optional<UserTable> voName = clientRepository.findByUsername(username);
            UserTable vo = clientRepository.getOne(username);

        if(vo!=null){
            System.out.println("유저있음");
            //이름으로 유저 가져오긴했는데 비밀번호는 어떻게 가져다가 비교할지 고민
            if (username.equals("admin")) {
                System.out.println("admin chk");
                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            }else {
                System.out.println("user chk");
                authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            }

            return new User(vo.getUsername(),vo.getUserpwd(),authorities);

        }else{
            System.out.println("유저없음");
            return new User(vo.getUsername(),vo.getUserpwd(),authorities);
        }
//        authorities.add(new SimpleGrantedAuthority("ROLE_USER")); //앞에 ROLE_을 붙여야 home.html에서 정상적으로 hasRole()구문을 인식




    }

}

package com.demo.lastdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http
                .authorizeRequests()
                .antMatchers("/","/goHome","/goLogin","/goJoin","/h2_db/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf()
                .ignoringAntMatchers("/h2_db/**")
                .and()
                .headers()
                .frameOptions()
                .disable()
                .and()
                .formLogin()
                .loginPage("/goLogin")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/goHome")
                .permitAll();


        //authorizeRequest 는 인증을 어떻게 할건지 (보안을 어떻게 할것인지에 대한 것)
        //antMatchers 특정 요청에 대한 리턴 설정  저기에는  루트랑 home은 모두 허가해준다
        //anyRequest() 나머지는 authenticated 인증을 거쳐야한다
        // and는 그냥 연결하는 말
        //formloing은 로그인 요청이 무엇이냐를 말함
        //loginPage는 로그인 페이지가 여기라는 의미
        //permitAll  모두 허가
        //logout  로그아웃 설정

        // .antMatchers("/admin/**").hasRole("ADMIN")   라고적으  //어드민 밑에 접근하려면 ADMIN롤을 가지고있어야한다. (예를들어서 작성한것)

        //hello를 누르는순간 anyRequest().authenticated에 걸린다 .
        //인증이 필요한 페이지에 들어왔기 때문에  fillter bean이 그걸 가로채서
        //formLogin을 처리하는 쪽으로 보내서 거기서 Login("/login")으로 보낸다.
        //이 요청 곧 MvcConfig에서 뷰리졸버를 통해 login.html로 보낸다.


    }


    //아래는 예시고 보통은  UserDetailService 자체를 bean으로 등록해서 사용한다.
//    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username("user")
//                        .password("password")
//                        .roles("USER")
//                        .build();
//
//
//        //name이랑 passoword는 당연히있어야하고
//        //roles이라는 개념이있다 . admin이 user의 상위 개념
//
//
//        return new InMemoryUserDetailsManager(user);
//    }


    //아래는 password 인코더 설정

    @Bean
    public PasswordEncoder passwordEncoder(){

        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }



}
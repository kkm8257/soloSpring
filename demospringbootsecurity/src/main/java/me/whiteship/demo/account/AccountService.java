package me.whiteship.demo.account;

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
import java.util.Collection;
import java.util.List;

@Service
public class AccountService implements UserDetailsService {


    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;



//    //autowired 대신에 이렇게 써도댐 , autowired를 쓰지않고도 주입받을수 있음
//
//    private final AccountRepository accounts;
//
//    public AccountService(AccountRepository accounts, PasswordEncoder passwordEncoder){
//        this.accounts = accounts;
//
//    }
//    ////////////

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("chk");
        Account account = accountRepository.findByEmail(username);
        //우리만의 객체인 account 니까 시큐리티가 알리가 없음
        //도메인들이 가질법한 계정관련된 프로퍼티들을 추상화한게 UserDetails 다 . 그래서 우리는 이 UserDetails로 바꾸어야한다.


        //원래 권한이란 디비에 있는 값을 보고 만드는 것이다.
        List<GrantedAuthority> authorities=new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER")); //앞에 ROLE_을 붙여야 home.html에서 정상적으로 hasRole()구문을 인식

        User test = new User(account.getEmail(),account.getPassword(),authorities);

        for (GrantedAuthority nameClass : test.getAuthorities()) {
            System.out.println(">>>>>"+nameClass.getAuthority()+"----"+nameClass.getClass());
        }


        //authoritity 정보들은 어떻게 활용이 가능한가.  WebSecurerityConfig에서 확인해보자
        // .antMatchers("/admin/**").hasRole("ADMIN")   라고적으  //어드민 밑에 접근하려면 ADMIN롤을 가지고있어야한다. (예를들어서 작성한것)

//          이런식으로 응용
//        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

//        if (username.equals("admin")) {
//            grantedAuthorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.name()));
//        } else {
//            grantedAuthorities.add(new SimpleGrantedAuthority(UserRole.USER.name()));
//        }



        //시큐리티에는 user라는 클래스가존재
        //user라는 클래스는 userDetails를 구현하고있음 , 기본 구현체라고 생각하면 된다.
        return new User(account.getEmail(),account.getPassword(),authorities);

        //예제
//        UserDetails userDetails = new UserDetails() {
//            @Override  //grantedAuthority 는 권한이다  .
//            public Collection<? extends GrantedAuthority> getAuthorities() {
//                List<GrantedAuthority> authorities = new ArrayList<>();
//                authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//                return authorities;
//            }
//
//            @Override
//            public String getPassword() {
//                return account.getPassword();
//            }
//
//            @Override
//            public String getUsername() {
//                return account.getEmail();  //여기서는 이메일을 이름으로 쓴다고 가정 (id)
//            }
//
//            @Override
//            public boolean isAccountNonExpired() {  //usernamed는 유일한 값이어야함 true로 설
//                return true;
//            }
//
//            @Override
//            public boolean isAccountNonLocked() {
//                return true;
//            }
//
//            @Override
//            public boolean isCredentialsNonExpired() {
//                return true;
//            }
//
//            @Override
//            public boolean isEnabled() {
//                return true;
//            }
//        };


        //return userDetails;
    }


    public Account save(Account account){
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return accountRepository.save(account);
    }

}

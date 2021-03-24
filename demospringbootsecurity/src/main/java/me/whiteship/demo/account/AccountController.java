package me.whiteship.demo.account;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

//    @Autowired
//    AccountRepository accounts;
//    서비스를 쓰는걸 더 선호하는데 , 여기서는 레포지토리그냥 가져옴 예제니까

    @Autowired
    AccountService accountService;  //위는 전체 구현전에 적은 메모



    @GetMapping("/create")
    public Account create(){
        Account account = new Account();
        account.setEmail("tenman2@naver.com");
        account.setPassword("password");

        return accountService.save(account);  //account
    }

}

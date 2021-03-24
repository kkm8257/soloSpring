package com.example.mytest.kimtestmaven;


import com.example.mytest.kimtestmaven.dao.CustomerRepository;
import com.example.mytest.kimtestmaven.domain.Customer;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomContorller {
    private final CustomerRepository repository;   //커스텀 레포지토리를 사용하기위해 멤버변수로 사용
    //spring boot가 커스토머 컨트롤러를 만들때   커스토머 레포지토리를 만들어서 넣어준다.


    public CustomContorller(CustomerRepository repository) {
        this.repository = repository;
    }

    @PutMapping("/customer")
    public Customer putCustomer(Customer customer) {
        //저장한후 저장한 결과값을 리턴 하는 것이 save
        //지금 우리는 위와같은 기능을하는 api를 만든것

        return repository.save(customer);
    }

    //localhost:8080/customer?id=1&name=요한3&address=강남3
    //postman

    @PostMapping("/customer")
    public Customer postCustomer(Customer customer) {
        //저장한후 저장한 결과값을 리턴 하는 것이 save
        //지금 우리는 위와같은 기능을하는 api를 만든것

        return repository.save(customer);
    }

    @GetMapping("/customer")
    public Customer getCustomer(Customer customer) {
        //저장한후 저장한 결과값을 리턴 하는 것이 save
        //지금 우리는 위와같은 기능을하는 api를 만든것

        return repository.save(customer);
    }

    @DeleteMapping("/customer")
    public void deleteCustomer(int id) {
        repository.deleteById(id);
    }

}

package com.example.mytest.kimtestmaven.dao;


import com.example.mytest.kimtestmaven.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {

    //Integer를 준 이유는 id를 지금 int 로 준상태라서

    //https://zetawiki.com/wiki/%EC%8A%A4%ED%94%84%EB%A7%81_CrudRepository_%EC%9D%B8%ED%84%B0%ED%8E%98%EC%9D%B4%EC%8A%A4

}

package com.example.myproject.login.dao;

import com.example.myproject.customer.dto.CustomerDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDao {

    List<CustomerDto> findUserByEmail(String email);

    CustomerDto registerUser(CustomerDto customerDto);
}

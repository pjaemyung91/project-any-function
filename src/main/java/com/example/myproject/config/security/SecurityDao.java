package com.example.myproject.config.security;

import com.example.myproject.customer.dto.CustomerDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SecurityDao {

    List<CustomerDto> findUserByEmail(String email);
}

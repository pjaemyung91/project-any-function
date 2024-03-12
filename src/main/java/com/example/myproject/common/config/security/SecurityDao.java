package com.example.myproject.common.config.security;

import com.example.myproject.customer.dto.Authority;
import com.example.myproject.customer.dto.CustomerDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SecurityDao {

    List<CustomerDto> findUserByUsername(String email);

    List<Authority> findAuthoritiesByCustomerId(int customerId);
}

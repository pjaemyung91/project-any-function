package com.example.myproject.customer.dao;

import com.example.myproject.customer.dto.CustomerDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerDao {

    int registerCustomer(CustomerDto customerDto);

    CustomerDto findCustomerById(int customerId);
}

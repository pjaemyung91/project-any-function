package com.example.myproject.customer.service;

import com.example.myproject.customer.dao.CustomerDao;
import com.example.myproject.customer.dto.CustomerDto;
import java.sql.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final BCryptPasswordEncoder bcryptPasswordEncoder;
    private final CustomerDao customerDao;

    @Override
    public CustomerDto registerCustomer(CustomerDto customerDto) {
        String hashedPwd = bcryptPasswordEncoder.encode(customerDto.getPwd());
        customerDto.setPwd(hashedPwd);
        customerDto.setCreateDt(String.valueOf(new Date(System.currentTimeMillis())));
        int customerId = customerDao.registerCustomer(customerDto);
        return customerDao.findCustomerById(customerId);
    }
}

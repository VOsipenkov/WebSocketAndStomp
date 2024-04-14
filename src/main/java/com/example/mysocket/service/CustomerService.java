package com.example.mysocket.service;

import com.example.mysocket.dto.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerService {
    public void process(Customer customer) {
        log.info("Successfully process customer {}", customer);
    }
}

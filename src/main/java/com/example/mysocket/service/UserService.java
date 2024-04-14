package com.example.mysocket.service;

import com.example.mysocket.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
    public void process(User user){
        log.info("Successfully process user {}", user);
    }
}

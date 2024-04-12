package com.appsdeveloperblog.tutorials.legacyusersservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.appsdeveloperblog.tutorials.legacyusersservice.data.UserEntity;
import com.appsdeveloperblog.tutorials.legacyusersservice.data.UsersRepository;

import jakarta.transaction.Transactional;

@Component
public class InitialSetup {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @EventListener
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent event) {
        UserEntity user = new UserEntity(
                1L,
                "qswe3mg84mfjtu",
                "firstNameTest",
                "lastNameTest",
                "test@gmail.com",
                bCryptPasswordEncoder.encode("test"),
                "",
                false);
        
        usersRepository.save(user);
    }
}

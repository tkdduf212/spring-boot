package com.example.demo.service.security;

import com.example.demo.advice.exception.CUserNotFoundException;
import com.example.demo.repository.UserJpaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserJpaRepo userJpaRepo;

    public UserDetails loadUserByUsername(String userPk) {
        return userJpaRepo.findByUid(userPk).orElseThrow(CUserNotFoundException::new);
//        return userJpaRepo.findByUid(Long.valueOf(userPk)).orElseThrow(CUserNotFoundException::new);
    }
}
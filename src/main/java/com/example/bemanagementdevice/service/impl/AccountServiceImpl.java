package com.example.bemanagementdevice.service.impl;


import com.example.bemanagementdevice.model.Account;
import com.example.bemanagementdevice.repository.AccountRepository;
import com.example.bemanagementdevice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public Account findById(String username) {
        return accountRepository.findById(username).orElseThrow(()->new UsernameNotFoundException("Not found"));
    }
}

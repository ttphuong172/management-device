package com.example.bemanagementdevice.service;


import com.example.bemanagementdevice.model.Account;

public interface AccountService {
    Account findById(String username);
}

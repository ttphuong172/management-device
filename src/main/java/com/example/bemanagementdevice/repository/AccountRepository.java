package com.example.bemanagementdevice.repository;


import com.example.bemanagementdevice.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,String> {
}

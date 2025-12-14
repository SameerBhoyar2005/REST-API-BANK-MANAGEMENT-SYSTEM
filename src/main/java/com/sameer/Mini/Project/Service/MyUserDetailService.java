package com.sameer.Mini.Project.Service;

import com.sameer.Mini.Project.Data.UserPrinciple;
import com.sameer.Mini.Project.Data.UserTable;
import com.sameer.Mini.Project.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserTable user = userRepo.findById(username).orElseThrow();
        if (user == null){
            throw new UsernameNotFoundException("USer not found");
        }

        return new UserPrinciple(user);
    }
}

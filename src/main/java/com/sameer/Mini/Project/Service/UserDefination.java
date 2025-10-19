package com.sameer.Mini.Project.Service;

import com.sameer.Mini.Project.Data.UserTable;
import com.sameer.Mini.Project.Repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDefination {

        UserRepo userRepo;

    public void createUser(UserTable body) {
        userRepo.save(body);
    }

    public List<UserTable> getAllUsers() {
        return userRepo.findAll();
    }

    public Optional<UserTable>getUserById(Long id) {
        return userRepo.findById(id);
    }
}

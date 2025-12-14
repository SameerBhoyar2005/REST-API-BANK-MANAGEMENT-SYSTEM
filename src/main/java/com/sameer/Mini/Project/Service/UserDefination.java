package com.sameer.Mini.Project.Service;

import com.sameer.Mini.Project.Data.LoginDto;
import com.sameer.Mini.Project.Data.UserTable;
import com.sameer.Mini.Project.Repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDefination {

    @Autowired
    UserRepo userRepo;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;

    public void createUser(UserTable body) {
        userRepo.save(body);
    }

    public List<UserTable> getAllUsers() {
        return userRepo.findAll();
    }

    public Optional<UserTable>getUserById(String id) {
        return userRepo.findById(id);
    }

    public String login(LoginDto loginDto) {

            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getId(), loginDto.getMob_no()));
            if (authentication.isAuthenticated()) {
                return jwtService.generateToken(loginDto.getId());
            }
            return "Unsuccessfull";

    }
}

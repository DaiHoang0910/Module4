package com.example.form.service.impl;

import com.example.form.model.User;
import com.example.form.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {
    private final List<User> users = new ArrayList<>();

    @Override
    public void saveUser(User user) {
        users.add(user);
    }
}

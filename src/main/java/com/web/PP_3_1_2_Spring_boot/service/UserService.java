package com.web.PP_3_1_2_Spring_boot.service;

import com.web.PP_3_1_2_Spring_boot.models.User;


import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void saveUser(User user);

    User getUser(int id);

    void deleteUser(int id);

    void updateUser (User user);
}


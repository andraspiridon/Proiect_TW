package com.dily.services;

import com.dily.entities.User;

/**
 * Created by Andra on 5/7/2017.
 */
public interface AuthService {
    User findByUsernameAndPassword(String username,String password);
}

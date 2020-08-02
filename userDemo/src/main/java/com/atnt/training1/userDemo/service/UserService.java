package com.atnt.training1.userDemo.service;

import com.atnt.training1.userDemo.model.User;
import com.atnt.training1.userDemo.utils.Utils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private final Map<Long, User> users = new HashMap<Long, User>();

    public void save(User user) {
        Long userId = Utils.getNextUserSequence();
        user.setUserId(userId);
        users.put(userId, user);
    }
    public User getUser(Long userId) {
        if (users.containsKey(userId)) {
            return users.get(userId);
        }
        else {
            return null;
        }
    }
}

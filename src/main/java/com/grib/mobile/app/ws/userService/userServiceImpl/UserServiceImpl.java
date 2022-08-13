package com.grib.mobile.app.ws.userService.userServiceImpl;

import com.grib.mobile.app.ws.ui.model.request.UserDetailsRequestModel;
import com.grib.mobile.app.ws.ui.model.responce.UserRest;
import com.grib.mobile.app.ws.userService.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    Map<String, UserRest> users;

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {
        UserRest returnUser = new UserRest();
        returnUser.setFirstName(userDetails.getFirstName());
        returnUser.setLastName(userDetails.getLastName());
        returnUser.setEmail(userDetails.getEmail());

        String userId = UUID.randomUUID().toString();
        returnUser.setUserId(userId);

        if (users == null) users = new HashMap<>();

        users.put(userId, returnUser);

        return returnUser;
    }
}

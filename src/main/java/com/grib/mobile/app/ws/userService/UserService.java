package com.grib.mobile.app.ws.userService;

import com.grib.mobile.app.ws.ui.model.request.UserDetailsRequestModel;
import com.grib.mobile.app.ws.ui.model.responce.UserRest;

public interface UserService {
    UserRest createUser(UserDetailsRequestModel userDetails);
}

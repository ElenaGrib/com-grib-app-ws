package com.grib.mobile.app.ws.ui.controller;

import com.grib.mobile.app.ws.ui.model.responce.UserRest;
import org.springframework.web.bind.annotation.*;

@RestController //this class will be able to receive http requests
@RequestMapping("users") //here we match our controller with "users" path, i.e. http://localhost:8080/users
public class UserController {

    //an example of method with 2 parameters
    //by default, both request params are required
    //to make one of them optional, we need to add defaultValue = "1" (like for page or limit)
    //or by adding required=false (like for sort). Note! NullPointerException can occur for not primitive types, good for String type for example
    //that's why we can add null check in the method's body, or just add default value
    @GetMapping//http://localhost:8080/users?page=1&limit=50&sort=forting
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "limit", defaultValue = "50") int limit,
                           @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
        // if (sort == null) sort = "des"; //here we can check for null
        return "get users was called: page=" + page + ", limit=" + limit + ", sort=" + sort;
    }

    //here we return an Object (model) instead of primitive type
    @GetMapping(path = "/{userId}") //http://localhost:8080/users/1
    public UserRest getUser(@PathVariable Long userId) { //@PathVariable annotation allows us to bind userId from request with our method
        UserRest returnUser = new UserRest();
        returnUser.setUserId(userId);
        returnUser.setFirstName("firstName");
        returnUser.setLastName("lastName");
        returnUser.setEmail("email@mail.com");
        return returnUser;
    }

    @PostMapping
    public String createUser() {
        return "create user was called";
    }

    @PutMapping
    public String updateUser() {
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "delete user was called";
    }
}

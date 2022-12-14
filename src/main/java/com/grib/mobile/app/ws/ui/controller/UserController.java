package com.grib.mobile.app.ws.ui.controller;

import com.grib.mobile.app.ws.exceptions.UserServiceException;
import com.grib.mobile.app.ws.ui.model.request.UserDetailsRequestModel;
import com.grib.mobile.app.ws.ui.model.responce.UserRest;
import com.grib.mobile.app.ws.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController //this class will be able to receive http requests
@RequestMapping("users") //here we match our controller with "users" path, i.e. http://localhost:8080/users
public class UserController {

    Map<String, UserRest> users;

    @Autowired
    UserService userService;

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
    //JSON - a default return format
    //to return different status code (acept of 200), we need to user ResponseEntity object instead of UserRest object
    @GetMapping(path = "/{userId}", //http://localhost:8080/users/1
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userId) { //@PathVariable annotation allows us to bind userId from request with our method
        if (true)
            throw new UserServiceException("A user service exception is thrown."); //here we throw our custom exception

        if (users.containsKey(userId)) {
            return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    //@RequestBody annotation is used when we want to receive information in the body from the Http request
    //and in this method we (1) CONSUME JSON or XML media type request and (2) PRODUCE JSON or XML media type response
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
        UserRest returnUser = userService.createUser(userDetails);
        return new ResponseEntity<>(returnUser, HttpStatus.CREATED);
    }

    @PutMapping
    public String updateUser() {
        return "update user was called";
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        users.remove(id);
        return ResponseEntity.noContent().build();
    }
}

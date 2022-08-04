package com.grib.mobile.app.ws.ui.model.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//if we want to get some JSON in the body of HTTP request, we should to create the model (class),
//which corresponds (class' fields) with the JSON from the request
//{
//        "firstName": "Alena",
//        "lastName": "Grib",
//        "email": "some@email.com",
//        "password": "123"
//        }
@Data
public class UserDetailsRequestModel {

    @NotNull(message = "FirstName cannot be missing")
    @Size(min = 2, message = "FirstName must be longer than 2 characters")
    private String firstName;

    @NotNull(message = "LastName cannot be missing")
    @Size(min = 2, message = "LastName must be longer than 2 characters")
    private String lastName;

    @NotNull(message = "Email cannot be missing")
    @Email(message = "Email format is not correct")
    private String email;

    @NotNull(message = "Password cannot be missing")
    @Size(min = 8, max = 16, message = "Password must be from 8 to 16 characters")
    private String password;
}

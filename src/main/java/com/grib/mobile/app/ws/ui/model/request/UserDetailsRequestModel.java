package com.grib.mobile.app.ws.ui.model.request;

import lombok.Data;

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
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}

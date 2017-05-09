package com.dily.controllers;

import com.dily.entities.User;
import com.dily.models.UserModel;
import com.dily.services.AuthService;
import com.dily.services.AuthServiceImpl;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;


/**
 * Created by Andra on 5/1/2017.
 */
@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value = "/api")
public class UserController {
    @Autowired
    AuthServiceImpl authServiceImpl;

    @RequestMapping(value="/login" , method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
    public ResponseEntity<User> jsonTest( @RequestBody UserModel userModel){
        System.out.println(userModel);
        String m =userModel.getUsername();
        String t =userModel.getPassword();
        System.out.println(m);
        System.out.println(t);
        User user = authServiceImpl.findByUsernameAndPassword(m,t);
        if (user != null) {
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

    }
}

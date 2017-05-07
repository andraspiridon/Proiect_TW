package com.dily.controllers;

import com.dily.entities.User;
import com.dily.services.AuthService;
import com.dily.services.AuthServiceImpl;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Created by Andra on 5/1/2017.
 */
@RestController
@CrossOrigin(value = "http://localhost:4200")
public class UserController {
    @Autowired
    AuthServiceImpl authServiceImpl;
    @RequestMapping(value = "/api/login/{json}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<User> jsonTest(JSONObject json){
        JSONObject jsonObject = json;
        String m = jsonObject.get("username").toString();
        String t = jsonObject.get("password").toString();
        User user = authServiceImpl.findByUsernameAndPassword(m,t);
        if (user != null) {
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }
}

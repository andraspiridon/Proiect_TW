package com.dily.controllers;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * Created by Andra on 5/1/2017.
 */
@RestController
@CrossOrigin(value = "http://localhost:4200")
public class UserController {

    @RequestMapping(value = {"json"},method = RequestMethod.GET)
    @ResponseBody
    public void jsonTest(JSONObject json){
        JSONObject jsonObject = json;
        String m = jsonObject.get("username").toString();
        String t = jsonObject.get("password").toString();
        System.out.println(m + 'a' +t);
    }
}

package com.say.tikujun.controller;


import com.say.tikujun.mapper.LoginMapper;
import com.say.tikujun.pojo.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    LoginMapper loginMapper;
    @PostMapping("/Login")
    public Map<String, Object> Login(@RequestBody Login login)
    {
        Map<String, Object> map = new HashMap<String, Object>(3);
        map.put("contact",login.getContact());
        map.put("state", loginMapper.getLogin(login.getContact(),login.getPassword()));
        return map;
    }
    @PostMapping("/A_Login")
    public Map<String, Object> A_Login(@RequestBody Login login)
    {
        Map<String, Object> map = new HashMap<String, Object>(3);
        map.put("contact",login.getContact());
        map.put("state", loginMapper.A_getLogin(login.getContact(),login.getPassword()));
        return map;
    }
}

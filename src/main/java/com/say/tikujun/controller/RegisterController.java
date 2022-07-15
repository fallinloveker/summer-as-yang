package com.say.tikujun.controller;

import com.say.tikujun.mapper.RegisterMapper;
import com.say.tikujun.pojo.Register;
import com.say.tikujun.pojo.UserUpdateInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    @Autowired
    RegisterMapper registerMapper;
    @PostMapping("/Register")
    public String Register(@RequestBody Register register)
    {
        String result = "";
        String password = "";
        String name = "'" + register.getName() + "'";
        //Map<String, Object> map = new HashMap<String, Object>(3);
        if(register.getPassword1().equals(register.getPassword2()))
        {
            password = "'" + register.getPassword1() + "'";
            if(registerMapper.getTest(register.getContact()) == 1)
            {
                result = "该手机号已注册！";
            }
            else{
                registerMapper.getRegister(name,register.getContact(),password);
                result = "注册成功！";
            }
        }
        else{
            result = "两次密码输入不一致！";
        }
        return result;
    }
    @PostMapping("/updateStudent")
    public String updateStudent(@RequestBody UserUpdateInfo userUpdateInfo)
    {
        if(userUpdateInfo.getPassword1().equals(userUpdateInfo.getPassword2()))
        {
            if(registerMapper.checkUserLoginInfo(userUpdateInfo.getId_s(), userUpdateInfo.getOldpassword()) == 1)
            {
                String password = userUpdateInfo.getPassword1();
                registerMapper.updateStudent(userUpdateInfo.getId_s(),password, userUpdateInfo.getOldpassword());
                return "修改成功！";
            }
            else{
                return "账户或密码错误！";
            }
        }
        else{
            return "两次密码不一致！";
        }
    }
    @PostMapping("/AdministratorRegister")
    public String AdministratorRegister(@RequestBody Register register)
    {
        String result = "";
        String password = "";
        String name = "'" + register.getName() + "'";
        if(register.getPassword1().equals(register.getPassword2()))
        {
            password = "'" + register.getPassword1() + "'";
            if(registerMapper.A_getTest(register.getContact()) == 1)
            {
                result = "该手机号已注册！";
            }
            else{
                registerMapper.A_getRegister(name,register.getContact(),password);
                result = "注册成功！";
            }
        }
        else{
            result = "两次密码输入不一致！";
        }
        return result;
    }
    @PostMapping("/updateAdministrator")
    public String updateAdministrator(@RequestBody UserUpdateInfo userUpdateInfo)
    {
        if(userUpdateInfo.getPassword1().equals(userUpdateInfo.getPassword2()))
        {
            if(registerMapper.checkAdministratorLoginInfo(userUpdateInfo.getId_s(), userUpdateInfo.getOldpassword()) == 1)
            {
                String password = userUpdateInfo.getPassword1();
                registerMapper.updateAdministrator(userUpdateInfo.getId_s(),password, userUpdateInfo.getOldpassword());
                return "修改成功！";
            }
            else{
                return "账户或密码错误！";
            }
        }
        else{
            return "两次密码不一致！";
        }
    }
}

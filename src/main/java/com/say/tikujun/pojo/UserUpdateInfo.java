package com.say.tikujun.pojo;

import lombok.Data;

@Data
public class UserUpdateInfo {
    private Integer id_s;
    private String oldpassword;
    private String password1;
    private String password2;
}

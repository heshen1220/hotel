package com.heshen.dto;

import lombok.Data;

@Data
public class PassWord {
    private String id;
    private String password;
    private String newPassword;
    private String again;
}

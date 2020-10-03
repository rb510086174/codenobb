package com.example.demo.base1;

import com.example.demo.test.KejiDog;

import java.io.Serializable;

/**
 * Created By RenBin6 on 2020/8/24 .
 */
public class User implements Serializable {
    private String userName;
    private String password;
    private KejiDog pet;

    public KejiDog getPet() {
        return pet;
    }

    public void setPet(KejiDog pet) {
        this.pet = pet;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package com.GUI.Users;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String tel;
    private String cuil;
    private List<String> sintomas = new ArrayList<>();
    private List<String> contactosEstrechos = new ArrayList<>();

    public User(String tel, String cuil) {
        this.tel = tel;
        this.cuil = cuil;
    }

    public String getTel() {
        return tel;
    }

    public String getCuil() {
        return cuil;
    }
}

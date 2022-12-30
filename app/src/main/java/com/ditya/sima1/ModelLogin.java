package com.ditya.sima1;

public class ModelLogin {

    String token;

    public ModelLogin(String type, String token, String datetime, String note) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
    public void setToken(String token) {
        this.token = token;
    }


}

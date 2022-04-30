package com.my.myapplication;

public class Users {
    public String name;
    public String status;
    public String image;
    public Users(String name, String status) {
        this.name = name;
       // this.image = image;
        this.status = status;
    }

    public Users(){

    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }
//
//    public String getImage() {
//        return image;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//    public void setImage(String image) {
//        this.image = image;
//    }
}

package com.udangoreng.divanandaapplication;

public class Pokemon {
    private String name, url;
//    private int number;
//    private int img;

    public Pokemon(String name, String url) {
        this.name = name;
        this.url = url;
//        this.img = img;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

//    public int getImg(){
//        return img;
//    }
}

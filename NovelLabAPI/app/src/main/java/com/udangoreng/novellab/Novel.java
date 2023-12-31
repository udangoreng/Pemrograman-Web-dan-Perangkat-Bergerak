package com.udangoreng.novellab;

public class Novel {

    private String title, writer, synopsis, img, year;

    public Novel (String title, String writer, String synopsis, String img, String year){
        this.img = img;
        this.title = title;
        this.writer = writer;
        this.synopsis = synopsis;
        this.year = year;
    }

    public String getCover() {
        return img;
    }

    public String getTitle() {
        return title;
    }

    public String getWriter() {
        return writer;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getYear() {
        return year;
    }
}

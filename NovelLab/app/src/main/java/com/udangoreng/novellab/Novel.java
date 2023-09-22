package com.udangoreng.novellab;

public class Novel {

    private int cover, year;
    private String title, writer, synopsis;

    public Novel (int cover, String title, String writer, String synopsis, int year){
        this.cover = cover;
        this.title = title;
        this.writer = writer;
        this.synopsis = synopsis;
        this.year = year;
    }

    public int getCover() {
        return cover;
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

    public int getYear() {
        return year;
    }
}

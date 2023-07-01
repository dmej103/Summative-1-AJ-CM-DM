package com.company.summativeProject1.model;

public class Quote {
    int id;
    String author;
    String quote;
    static int TrackID = 0;

    public Quote(String author, String quote){
        setId(TrackID++);
        this.author=author;
        this.quote = quote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}

package com.example.library;

public class Book {

    private int id;
    private String name;
    private String author;
    private int pagenumber;
    private String imageurl;
    private String Description;

    public Book(int id, String name, String author, int pagenumber, String imageurl, String description) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.pagenumber = pagenumber;
        this.imageurl = imageurl;
        Description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getPagenumber() {
        return pagenumber;
    }
    public void setPagenumber(int pagenumber) {
        this.pagenumber   =   pagenumber   ;
    }
    public String getImageurl() {
        return imageurl;
    }
    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
    public String getDescription() {
        return Description;
    }
    public void setDescription(String description) {
        Description = description;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ",   pagenumber   =    "   +   pagenumber    +
                ", imageurl='" + imageurl + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }
}

package org.jfr0st.model;

public class Book {
    private int id;
    private Integer person_id;
    private String title;
    private String author;
    private int w_year;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getW_year() {
        return w_year;
    }

    public void setW_year(int w_year) {
        this.w_year = w_year;
    }
}

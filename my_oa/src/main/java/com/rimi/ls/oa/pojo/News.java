package com.rimi.ls.oa.pojo;

public class News {

    private long id;
    private String title;
    private String content;
    private String up_time;

    public News() {
    }

    public News(long id, String title, String content, String up_time) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.up_time = up_time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUp_time() {
        return up_time;
    }

    public void setUp_time(String up_time) {
        this.up_time = up_time;
    }
}

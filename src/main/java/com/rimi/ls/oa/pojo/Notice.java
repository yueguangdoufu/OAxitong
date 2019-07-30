package com.rimi.ls.oa.pojo;

public class Notice {

    private long id;
    private String title;
    private String content;
    private String up_time;
    private String name;
    private Byte important;

    public Notice() {
    }

    public Notice(long id, String title, String content, String up_time, String name, Byte important) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.up_time = up_time;
        this.name = name;
        this.important = important;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getImportant() {
        return important;
    }

    public void setImportant(Byte important) {
        this.important = important;
    }
}

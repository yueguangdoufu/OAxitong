package com.rimi.ls.oa.pojo;

public class Document {

    private long id;
    private String title;
    private String content;
    private String file;
    private String up_time;
    private String name;

    public Document() {
    }

    public Document(long id, String title, String content, String file, String up_time, String name) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.file = file;
        this.up_time = up_time;
        this.name = name;
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

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
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
}

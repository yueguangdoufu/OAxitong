package com.rimi.ls.oa.pojo;

public class Regulation {

    private long id;
    private String file;

    public Regulation() {
    }

    public Regulation(long id, String file) {
        this.id = id;
        this.file = file;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}

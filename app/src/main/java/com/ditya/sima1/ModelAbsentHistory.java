package com.ditya.sima1;

public class ModelAbsentHistory {

    String title, datetime, note;

    public ModelAbsentHistory(String type, String title, String datetime, String note) {
//        this.type = type;
        this.title = title;
        this.datetime = datetime;
        this.note = note;
    }

    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDatetime() {
        return this.datetime;
    }
    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getNote() {
        return this.note;
    }
    public void setNote(String note) {
        this.note = note;
    }

}

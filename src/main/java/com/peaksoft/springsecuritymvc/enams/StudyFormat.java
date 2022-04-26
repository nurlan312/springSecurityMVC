package com.peaksoft.springsecuritymvc.enams;

public enum StudyFormat {

    ONLINE( "Online"),
    OFFLINE("Offline");

    String format;

    StudyFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}

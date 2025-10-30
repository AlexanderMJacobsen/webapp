package com.danmarkmodmadspild.webapp.model;

import java.time.LocalDate;


public class AboutText {

    private String header;
    private String line_1;
    private String line_2;
    private String line_3;
    private String line_4;
    private String line_5;
    private LocalDate creationDate;



    public AboutText(String header, String line_1, String line_2, String line_3, String line_4, String line_5, LocalDate creationDate) {
        this.header = header;
        this.line_1 = line_1;
        this.line_2 = line_2;
        this.line_3 = line_3;
        this.line_4 = line_4;
        this.line_5 = line_5;
        this.creationDate = creationDate;
    }

    public String getHeader() {
        return header;
    }

    public String getLine_1() {
        return line_1;
    }

    public String getLine_2() {
        return line_2;
    }

    public String getLine_3() {
        return line_3;
    }

    public String getLine_4() {
        return line_4;
    }

    public String getLine_5() {
        return line_5;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public String toString() {
        return  header + '\'' +
                line_1 + '\'' +
                line_2 + '\'' +
                line_3 + '\'' +
                line_4 + '\'' +
                line_5 + '\'' +
                creationDate;
    }
}

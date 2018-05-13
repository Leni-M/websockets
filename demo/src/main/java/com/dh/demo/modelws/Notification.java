package com.dh.demo.modelws;

public class Notification {
    private String textoContent;

    public Notification(String textoContent) {
        this.textoContent = textoContent;
    }
    public Notification() {

    }
    public String getTextoContent() {
        return textoContent;
    }

    public void setTextoContent(String textoContent) {
        this.textoContent = textoContent;
    }
}

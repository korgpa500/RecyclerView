package com.example.yousryelwrdany.recyclerview;

/**
 * Created by Yousry Elwrdany on 31/03/2018.
 */

public class ListItem {

    private String head;
    private String desc;
    private String imageUri;

    public ListItem(String head, String desc ,String imageUri) {
        this.desc = desc;
        this.head = head;
        this.imageUri = imageUri;
    }

    public String getHead() {
        return head;
    }

    public String getDescription() {
        return desc;
    }

    public String getImageUri(){
        return imageUri;
    }

}

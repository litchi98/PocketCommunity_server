package com.litchi.pocketcommunity.bean;

public class ImageFile extends ImageFileKey {

    public static final int TYPE_AVATAR = 0;
    public static final int TYPE_IDENTIFICATION = 1;
    public static final int TYPE_CONTRACT = 2;

    private Integer userId;

    private Integer type;

    private String name;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}
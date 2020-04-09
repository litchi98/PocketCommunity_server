package com.litchi.pocketcommunity.bean;

public class ImageFile extends ImageFileKey {

    private static final int TYPE_ID_CARD = 0;
    private static final int TYPE_CONTRACT = 1;
    private static final int TYPE_AVATAR = 2;

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
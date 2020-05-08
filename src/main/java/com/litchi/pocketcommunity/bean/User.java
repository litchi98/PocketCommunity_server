package com.litchi.pocketcommunity.bean;

public class User extends UserKey {
    private String name;

    private String password;

    private String gender;

    private String telNumber;

    private String identificationId;

    private Integer avatarImageId;

    private Integer roleId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber == null ? null : telNumber.trim();
    }

    public String getIdentificationId() {
        return identificationId;
    }

    public void setIdentificationId(String identificationId) {
        this.identificationId = identificationId == null ? null : identificationId.trim();
    }

    public Integer getAvatarImageId() {
        return avatarImageId;
    }

    public void setAvatarImageId(Integer avatarImageId) {
        this.avatarImageId = avatarImageId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
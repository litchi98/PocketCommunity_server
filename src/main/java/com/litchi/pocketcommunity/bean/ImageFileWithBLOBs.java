package com.litchi.pocketcommunity.bean;

public class ImageFileWithBLOBs extends ImageFile {
    private byte[] file;

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
}
package com.litchi.pocketcommunity.bean;

public class Verify {

    public static final String VERIFY_REFUSAL = "refusal";
    public static final String VERIFY_COMPLETE = "complete";
    public static final String VERIFY_PROCESSING = "processing";

    public Verify(Integer userId, String verifyResult, String msg) {
        this.userId = userId;
        this.verifyResult = verifyResult;
        this.msg = msg;
    }

    private Integer id;

    private Integer userId;

    private String verifyResult;

    private String msg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getVerifyResult() {
        return verifyResult;
    }

    public void setVerifyResult(String verifyResult) {
        this.verifyResult = verifyResult == null ? null : verifyResult.trim();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }
}
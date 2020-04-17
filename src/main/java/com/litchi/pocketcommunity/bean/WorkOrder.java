package com.litchi.pocketcommunity.bean;

import java.util.Date;

public class WorkOrder extends WorkOrderKey {

    public static final int STATE_TO_BE_PROCESSED = 0;
    public static final int STATE_PROCESSING = 1;
    public static final int STATE_TO_BE_CONFIRMED = 2;
    public static final int STATE_FINISH = 3;

    private Integer proposerId;

    private Integer currentProcessorId;

    private Integer state;

    private String content;

    private Date proposeDate;

    public Integer getProposerId() {
        return proposerId;
    }

    public void setProposerId(Integer proposerId) {
        this.proposerId = proposerId;
    }

    public Integer getCurrentProcessorId() {
        return currentProcessorId;
    }

    public void setCurrentProcessorId(Integer currentProcessorId) {
        this.currentProcessorId = currentProcessorId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getProposeDate() {
        return proposeDate;
    }

    public void setProposeDate(Date proposeDate) {
        this.proposeDate = proposeDate;
    }
}
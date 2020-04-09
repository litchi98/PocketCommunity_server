package com.litchi.pocketcommunity.util;

import java.util.HashMap;
import java.util.Map;

public class ResultMessage {

    public static final String ERROR_RESULT = "500";
    public static final String SUCCESS_RESULT = "200";
    public static final String UNAUTHORIZED = "401";

    private String result;
    private String msg;
    private Map<String, Object> data;

    public static ResultMessage getInstance(){
        return new ResultMessage();
    }

    public ResultMessage msg(String msg){
        this.msg = msg;
        return this;
    }

    public ResultMessage result(String result){
        this.result = result;
        return this;
    }

    public ResultMessage putData(String key, Object value){
        if (data == null){
            data = new HashMap<>();
        }
        data.put(key, value);
        return this;
    }

    public Object getData(String key){
        if (data != null){
            return data.get(key);
        }
        return null;
    }

    public void removeData(String key){
        if (data != null){
            data.remove(key);
        }
    }

    public void removeAllData(){
        data = null;
    }

    public ResultMessage clear(){
        this.result = null;
        this.msg = null;
        this.data = null;
        return this;
    }

    public String getResult() {
        return result;
    }

    public String getMsg() {
        return msg;
    }

    public Map<String, Object> getData() {
        return data;
    }
}

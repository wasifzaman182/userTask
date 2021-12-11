package com.ari.userTask.response;

import lombok.Builder;

/**
 * Created by Arittek-002 on 28/07/2021.
 */
@Builder
public class BaseResponse {

    private String responseCode;
    private String responseMessage;
    private Object responseObject;

    public BaseResponse() {
    }

    public BaseResponse(String responseCode, String responseMessage, Object responseObject) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.responseObject = responseObject;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public Object getResponseObject() {
        return responseObject;
    }

    public void setResponseObject(Object responseObject) {
        this.responseObject = responseObject;
    }
}

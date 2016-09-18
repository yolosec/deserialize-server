package com.klinec.deserialize.server.api.response;

/**
 * Simple success response
 *
 * Created by dusanklinec on 01.09.16.
 */
public class ResultResponse extends GeneralResponse {
    protected boolean success=true;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}

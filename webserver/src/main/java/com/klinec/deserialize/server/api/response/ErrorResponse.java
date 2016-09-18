package com.klinec.deserialize.server.api.response;

import org.json.JSONObject;

/**
 * Indicates error in the request processing.
 *
 * Created by dusanklinec on 01.09.16.
 */
public class ErrorResponse extends GeneralResponse {
    protected String errorCode;
    protected String error;
    protected JSONObject cause;

    public ErrorResponse() {
    }

    public ErrorResponse(String error) {
        this.errorCode = "ERROR";
        this.error = error;
    }

    public ErrorResponse(String errorCode, String error) {
        this.errorCode = "ERROR";
        this.error = error;
    }

    public ErrorResponse(String errorCode, String error, JSONObject cause) {
        this.errorCode = errorCode;
        this.error = error;
        this.cause = cause;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getError() {
        return error;
    }

    public JSONObject getCause() {
        return cause;
    }

    public ErrorResponse setErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public ErrorResponse setError(String error) {
        this.error = error;
        return this;
    }

    public ErrorResponse setCause(JSONObject cause) {
        this.cause = cause;
        return this;
    }
}

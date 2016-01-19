package com.angkorteam.baasbox.sdk.java.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

/**
 * Created by socheatkhauv on 1/14/16.
 */
public class ErrorResponse extends Response {

    @Expose
    @SerializedName("message")
    private String message;

    @Expose
    @SerializedName("resource")
    private String resource;

    @Expose
    @SerializedName("method")
    private String method;

    @Expose
    @SerializedName("request_header")
    private Map<String, Object> requestHeader;

    @Expose
    @SerializedName("API_version")
    private String version;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Map<String, Object> getRequestHeader() {
        return requestHeader;
    }

    public void setRequestHeader(Map<String, Object> requestHeader) {
        this.requestHeader = requestHeader;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
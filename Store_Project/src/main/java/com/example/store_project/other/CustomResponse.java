package com.example.store_project.other;

public class CustomResponse {
    private String status;
    private String exceptionText;

    public CustomResponse() {
    }

    public CustomResponse(String status, String exceptionText) {
        this.status = status;
        this.exceptionText = exceptionText;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExceptionText() {
        return exceptionText;
    }

    public void setExceptionText(String exceptionText) {
        this.exceptionText = exceptionText;
    }
}

package com.samples.enums;

public enum VisualElements {
    SUCCESS_MESSAGE("success_message"),
    ERROR_MESSAGE("error_message");

    private String value;

    VisualElements(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}

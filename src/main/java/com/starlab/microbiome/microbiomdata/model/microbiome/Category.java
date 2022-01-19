package com.starlab.microbiome.microbiomdata.model.microbiome;


public enum Category implements CodeDescription{
    BENEFIT("B", "유익균"),
    HARMFUL("H", "유해균"),
    NORMAL("N", "중간균"),
    UNKNOWN("U", "모름");

    private String code;
    private String description;

    Category(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }
}

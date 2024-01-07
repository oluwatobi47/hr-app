package uk.ac.bcu.oluwatobi.hrapp.model;

public enum PipelineModelType {
    JOB_DESCRIPTION("das"),
    JOB_APPLICATION("JA"),
    JOB_POST("JP"),
    COMPANY_INFO("COMP");

    private final String value;

    PipelineModelType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}

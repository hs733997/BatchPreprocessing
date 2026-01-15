package com.chakravarthy.project.rest.request;

public class BatchRequest {

    private String filePath;

    private String sourceSystem;

    private  String fileType;

    private String toWritingLocation;



    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getToWritingLocation() {
        return toWritingLocation;
    }

    public void setToWritingLocation(String toWritingLocation) {
        this.toWritingLocation = toWritingLocation;
    }

    public String getFileType() {
        return fileType;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getSourceSystem() {
        return sourceSystem;
    }
}

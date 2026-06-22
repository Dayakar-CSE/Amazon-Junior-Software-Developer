package com.lab.model;

public class S3File {
    private String fileName;
    private String bucketName;
    private String status;

    public S3File() {
    }

    public S3File(String fileName, String bucketName, String status) {
        this.fileName = fileName;
        this.bucketName = bucketName;
        this.status = status;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

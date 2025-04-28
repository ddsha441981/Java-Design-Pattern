package com.cwc.adapter.pattern.model.enums;

public enum Statuss {
    PENDING,
    SUCCESS,
    FAILURE,
    ERROR,
    UNKNOWN,
    PROCESSING,
    PROCESSED;

    public boolean isSuccess() {
        return this == SUCCESS;
    }

    public boolean isFailure() {
        return this == FAILURE || this == ERROR;
    }

    public boolean isProcessing() {
        return this == PROCESSING;
    }
}

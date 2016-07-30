package com.pahlsoft.booster.com.pahlsoft.booster.model;

import java.util.List;

public class Server {
    private String serverName;
    private String changeRecordStatus;
    private String changeRecord;
    private String serverOwnerName;
    private String serverOwnerID;
    private String patchingStatus;

    public String getServerOwnerID() {
        return serverOwnerID;
    }

    public void setServerOwnerID(String serverOwnerID) {
        this.serverOwnerID = serverOwnerID;
    }

    private List<String> serverUAIDs;
    private String lastPatchingDate;
    private List<String> pendingPatchInfo;
    private boolean patchingRequired;
    private boolean rebootRequired;

    public boolean isPatchingRequired() {
        return patchingRequired;
    }

    public void setPatchingRequired(boolean patchingRequired) {
        this.patchingRequired = patchingRequired;
    }

    public boolean isRebootRequired() {
        return rebootRequired;
    }

    public void setRebootRequired(boolean rebootRequired) {
        this.rebootRequired = rebootRequired;
    }

    public List<String> getPendingPatchInfo() {
        return pendingPatchInfo;
    }

    public void setPendingPatchInfo(List<String> pendingPatchInfo) {
        this.pendingPatchInfo = pendingPatchInfo;
    }

    public String getLastPatchingDate() {
        return lastPatchingDate;
    }

    public void setLastPatchingDate(String lastPatchingDate) {
        this.lastPatchingDate = lastPatchingDate;
    }

    public String getServerOwnerName() {
        return serverOwnerName;
    }

    public void setServerOwnerName(String serverOwnerName) {
        this.serverOwnerName = serverOwnerName;
    }

    public List<String> getServerUAIDs() {
        return serverUAIDs;
    }

    public void setServerUAIDs(List<String> serverUAIDs) {
        this.serverUAIDs = serverUAIDs;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getChangeRecordStatus() {
        return changeRecordStatus;
    }

    public void setChangeRecordStatus(String changeRecordStatus) {
        this.changeRecordStatus = changeRecordStatus;
    }

    public String getChangeRecord() {
        return changeRecord;
    }

    public void setChangeRecord(String changeRecord) {
        this.changeRecord = changeRecord;
    }

    public String getPatchingStatus() {
        return patchingStatus;
    }

    public void setPatchingStatus(String patchingStatus) {
        this.patchingStatus = patchingStatus;
    }
}

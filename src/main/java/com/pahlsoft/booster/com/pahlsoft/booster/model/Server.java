package com.pahlsoft.booster.com.pahlsoft.booster.model;

public class Server {
    private String _id;
    private String operatingSystem;
    private String operatingSystemVersion;
    private String lastUpdateDate;
    private String relatedUaids;
    private String serverOwnerId;

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getOperatingSystemVersion() {
        return operatingSystemVersion;
    }

    public void setOperatingSystemVersion(String operatingSystemVersion) {
        this.operatingSystemVersion = operatingSystemVersion;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }


    public String getServerOwnerId() {
        return serverOwnerId;
    }

    public void setServerOwnerId(String serverOwnerId) {
        this.serverOwnerId = serverOwnerId;
    }

    public String getRelatedUaids() {
        return relatedUaids;
    }

    public void setRelatedUaids(String relatedUaids) {
        this.relatedUaids = relatedUaids;
    }
}

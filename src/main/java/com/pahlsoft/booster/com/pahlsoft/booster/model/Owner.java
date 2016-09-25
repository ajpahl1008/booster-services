package com.pahlsoft.booster.com.pahlsoft.booster.model;

public class Owner {
    private String _id;
    private String ownerFirstName;

    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    public void setOwnerFirstName(String ownerFirstName) {
        this.ownerFirstName = ownerFirstName;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

    private String ownerLastName;

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

}

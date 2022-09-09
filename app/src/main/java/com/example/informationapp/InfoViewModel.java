package com.example.informationapp;

public class InfoViewModel {
    String farmId;
    String serverId;
    String id;
    String secret;

    public InfoViewModel(String farmId, String serverId, String id, String secret) {
        this.farmId = farmId;
        this.serverId = serverId;
        this.id = id;
        this.secret = secret;
    }

    public String getFarmId() {
        return farmId;
    }

    public void setFarmId(String farmId) {
        this.farmId = farmId;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}

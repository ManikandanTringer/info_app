package com.example.informationapp;

public class InfoViewModel {
    int farmId;
    int serverId;
    int id;
    String secret;

    public InfoViewModel(int farmId, int serverId, int id, String secret) {
        this.farmId = farmId;
        this.serverId = serverId;
        this.id = id;
        this.secret = secret;
    }

    public int getFarmId() {
        return farmId;
    }

    public void setFarmId(int farmId) {
        this.farmId = farmId;
    }

    public int getServerId() {
        return serverId;
    }

    public void setServerId(int serverId) {
        this.serverId = serverId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}

package com.techelevator.model;

public class Request {

    private int requestId;
    private int customerId;
    private int vehicleId;
    private String description;

    public Request() {
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int repairId) {
        this.requestId = repairId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Request{" +
                "requestId=" + requestId +
                ", customerId=" + customerId +
                ", vehicleId=" + vehicleId +
                ", description='" + description + '\'' +
                '}';
    }
}

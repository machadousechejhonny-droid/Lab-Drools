package com.drools.Lab5.model;

public class AirlineResponse {

    private boolean businessClassUpgrade;
    private boolean priorityCheckIn;
    private double discountPercentage;
    private boolean upgradeEligible = true;
    private String assignedSeat;
    private boolean emergencyExitSeatOccupied;
    private double compensationAmount;
    private int loyaltyPointsAdded;
    private boolean luggageAllowed = true;
    private boolean vipLoungeAccess;
    private boolean preferentialFamilySeat;
    private String message = "";

    public AirlineResponse() {}

    public void addMessage(String msg) {
        if (message == null || message.isEmpty()) {
            message = msg;
        } else {
            message = message + " | " + msg;
        }
    }

    public boolean isBusinessClassUpgrade() { return businessClassUpgrade; }

    public void setBusinessClassUpgrade(boolean businessClassUpgrade) {
        this.businessClassUpgrade = businessClassUpgrade;
    }

    public boolean isPriorityCheckIn() { return priorityCheckIn; }

    public void setPriorityCheckIn(boolean priorityCheckIn) {
        this.priorityCheckIn = priorityCheckIn;
    }

    public double getDiscountPercentage() { return discountPercentage; }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public boolean isUpgradeEligible() { return upgradeEligible; }

    public void setUpgradeEligible(boolean upgradeEligible) {
        this.upgradeEligible = upgradeEligible;
    }

    public String getAssignedSeat() { return assignedSeat; }

    public void setAssignedSeat(String assignedSeat) { this.assignedSeat = assignedSeat; }

    public boolean isEmergencyExitSeatOccupied() { return emergencyExitSeatOccupied; }

    public void setEmergencyExitSeatOccupied(boolean emergencyExitSeatOccupied) {
        this.emergencyExitSeatOccupied = emergencyExitSeatOccupied;
    }

    public double getCompensationAmount() { return compensationAmount; }

    public void setCompensationAmount(double compensationAmount) {
        this.compensationAmount = compensationAmount;
    }

    public int getLoyaltyPointsAdded() { return loyaltyPointsAdded; }

    public void setLoyaltyPointsAdded(int loyaltyPointsAdded) {
        this.loyaltyPointsAdded = loyaltyPointsAdded;
    }

    public boolean isLuggageAllowed() { return luggageAllowed; }

    public void setLuggageAllowed(boolean luggageAllowed) {
        this.luggageAllowed = luggageAllowed;
    }

    public boolean isVipLoungeAccess() { return vipLoungeAccess; }

    public void setVipLoungeAccess(boolean vipLoungeAccess) {
        this.vipLoungeAccess = vipLoungeAccess;
    }

    public boolean isPreferentialFamilySeat() { return preferentialFamilySeat; }

    public void setPreferentialFamilySeat(boolean preferentialFamilySeat) {
        this.preferentialFamilySeat = preferentialFamilySeat;
    }

    public String getMessage() { return message; }

    public void setMessage(String message) { this.message = message; }
}

package com.slphase1.rentCam;

public class Camera {
    private static int count = 0; // Static variable to track the number of cameras added
    private int serialNumber;
    private String brand;
    private String model;
    private double rentalAmount;
    private String status;

    public Camera(String brand, String model, double rentalAmount) {
        this.serialNumber = ++count;
        this.brand = brand;
        this.model = model;
        this.rentalAmount = rentalAmount;
        this.status = "AVAILABLE"; // Default status is available
    }

    // Getters for camera attributes
    public int getSerialNumber() {
        return serialNumber;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getRentalAmount() {
        return rentalAmount;
    }

    public String getStatus() {
        return status;
    }

    // Method to set camera status
    public void setStatus(String status) {
        this.status = status;
    }
}
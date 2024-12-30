package com.javaWeb.repository.entity;

public class BuildingEntity {
    private String name; // Tên tòa nhà
    private Integer districtId; // ID quận
    private String street; // Tên đường
    private String ward; // Phường
    private Integer numberOfBasement; // Số tầng hầm
    private Double floorArea; // Diện tích sàn
    private Double rentPrice; // Giá thuê

    // Getters và Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getDistrictId() {
        return districtId;
    }
    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }

    public String getWard() {
        return ward;
    }
    public void setWard(String ward) {
        this.ward = ward;
    }

    public Integer getNumberOfBasement() {
        return numberOfBasement;
    }
    public void setNumberOfBasement(Integer numberOfBasement) {
        this.numberOfBasement = numberOfBasement;
    }

    public Double getFloorArea() {
        return floorArea;
    }
    public void setFloorArea(Double floorArea) {
        this.floorArea = floorArea;
    }

    public Double getRentPrice() {
        return rentPrice;
    }
    public void setRentPrice(Double rentPrice) {
        this.rentPrice = rentPrice;
    }
}

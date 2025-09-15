package com.github.nicolas.stock.entity;

import jakarta.persistence.*;

//@Entity
//@Table(name = "device")
public class Device {

    public Device() {
    }

    public Device(int id, String asset_tag, String serial_number, String brand, String model, String status, int type_id) {
        this.id = id;
        this.asset_tag = asset_tag;
        this.serial_number = serial_number;
        this.brand = brand;
        this.model = model;
        this.status = status;
        this.type_id = type_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String asset_tag;
    private String serial_number;
    private String brand;
    private String model;
    private String status;
    private int type_id;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAsset_tag() {
        return asset_tag;
    }

    public void setAsset_tag(String asset_tag) {
        this.asset_tag = asset_tag;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }
}

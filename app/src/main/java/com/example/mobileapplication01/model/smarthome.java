package com.example.mobileapplication01.model;

import androidx.annotation.NonNull;
import java.io.Serializable;

public class smarthome implements Serializable {
    String smarthome_image;
    String smarthome_name;
    String smarthome_price;
    String smarthome_detail;

    // ฟิลด์ใหม่
    private boolean isChecked;

    // Getter และ Setter สำหรับ isChecked
    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getSmarthome_detail() {
        return smarthome_detail;
    }

    public void setSmarthome_detail(String smarthome_detail) {
        this.smarthome_detail = smarthome_detail;
    }

    public String getSmarthome_price() {
        return smarthome_price;
    }

    public void setSmarthome_price(String smarthome_price) {
        this.smarthome_price = smarthome_price;
    }

    public String getSmarthome_name() {
        return smarthome_name;
    }

    public void setSmarthome_name(String smarthome_name) {
        this.smarthome_name = smarthome_name;
    }


    public String getSmarthome_image() {
        return smarthome_image;
    }

    public void setSmarthome_image(String smarthome_image) {
        this.smarthome_image = smarthome_image;
    }


}
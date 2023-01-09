package com.api.medidores.api.medidores.dto;

public class Medidor_dto {

    private String meter_date;

    private Double value;

    public void setMeter_date(String meter_date) {
        this.meter_date = meter_date;
    }

    public String getMeter_date() {
        return meter_date;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }
}

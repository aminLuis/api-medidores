package com.api.medidores.api.medidores.entities;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "medidor")
@EntityListeners(AuditingEntityListener.class)
public class Medidor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String meter_date;

    private Double value;

    private Long meter_id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

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

    public void setMeter_id(Long meter_id) {
        this.meter_id = meter_id;
    }

    public Long getMeter_id() {
        return meter_id;
    }

}

package com.api.medidores.api.medidores.entities;

import org.hibernate.grammars.hql.HqlParser.DatetimeFieldContext;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;

@Entity
@Table(name = "medidor")
@EntityListeners(AuditingEntityListener.class)
public class Medidor {

    private DatetimeFieldContext meter_date;

    private Double value;

    public void setMeter_date(DatetimeFieldContext meter_date) {
        this.meter_date = meter_date;
    }

    public DatetimeFieldContext getMeter_date() {
        return meter_date;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

}

package com.api.medidores.api.medidores.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.medidores.api.medidores.Interfaces.IMedidor;
import com.api.medidores.api.medidores.dto.Medidor_dto;
import com.api.medidores.api.medidores.entities.Medidor;
import com.api.medidores.api.medidores.logica.Medidor_logica;

@RestController
@RequestMapping("/api")
public class Medidor_controller {

    @Autowired
    private IMedidor medidor_service;

    Medidor_logica logica = new Medidor_logica();

    @GetMapping("/medidor")
    public List<Medidor> getMedidores() {
        return this.medidor_service.findAll();
    }

    @GetMapping("/medidor/cont")
    public List<Medidor_dto> getCont(String date, String periodo) {

        if (periodo.equalsIgnoreCase("daily")) {
            return logica.daily(getMedidores(), date);
        }
        if (periodo.equalsIgnoreCase("weekly")) {
            return logica.weekly(date, getMedidores());
        } else {
            return logica.monthly(null, getMedidores());
        }

    }
}

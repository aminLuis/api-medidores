package com.api.medidores.api.medidores.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.medidores.api.medidores.Interfaces.IMedidor;
import com.api.medidores.api.medidores.dao.Medidor_repository_dao;
import com.api.medidores.api.medidores.entities.Medidor;

@Service
public class Medidor_service implements IMedidor {

    @Autowired
    private Medidor_repository_dao medidor_dao;

    @Override
    public List<Medidor> findAll() {
        return this.medidor_dao.findAll();
    }

}

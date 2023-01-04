package com.api.medidores.api.medidores.dao;

import org.hibernate.grammars.hql.HqlParser.DatetimeFieldContext;
import org.springframework.data.jpa.repository.JpaRepository;

import com.api.medidores.api.medidores.entities.Medidor;

public interface Medidor_repository_dao extends JpaRepository<Medidor, DatetimeFieldContext> {

}

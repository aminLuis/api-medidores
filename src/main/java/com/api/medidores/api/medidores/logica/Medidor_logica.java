package com.api.medidores.api.medidores.logica;

import java.util.ArrayList;
import java.util.List;

import com.api.medidores.api.medidores.dto.Medidor_dto;
import com.api.medidores.api.medidores.entities.Medidor;

public class Medidor_logica {

    public List<Medidor_dto> daily(List<Medidor> data, String dia) {

        String fecha = "";
        List<Medidor_dto> list = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            String splited[] = data.get(i).getMeter_date().split(",");
            String dia_mes[] = splited[0].split(" ");
            fecha = splited[1] + "-" + convertir_mes(dia_mes[0]) + "-" + dia_mes[1];
            String date = fecha.replace(" ", "");

            if (date.equalsIgnoreCase("2022-10-12")) {
                Medidor_dto temp = new Medidor_dto();
                temp.setMeter_date(data.get(i).getMeter_date());
                temp.setValue(data.get(i).getValue());
                list.add(temp);
            } else {
                break;
            }
        }

        return list;
    }

    public List<Medidor_dto> weekly(String dia, List<Medidor> data) {
        List<String> fechas = fechas_registradas(data);
        boolean start = false;
        List<Medidor_dto> list = new ArrayList<>();

        for (int i = 0; i < fechas.size(); i++) {
            if (fechas.get(i).equalsIgnoreCase(dia)) {
                start = true;
            }
            if (start) {
                Medidor_dto temp = new Medidor_dto();
                temp.setMeter_date(fechas.get(i));
                temp.setValue(sumar_value(daily(data, fechas.get(i))));
                list.add(temp);
            }
        }

        return list;
    }

    public List<String> fechas_registradas(List<Medidor> data) {
        List<String> fechas = new ArrayList<>();
        String fecha = "";
        String actual = "";

        for (int i = 0; i < data.size(); i++) {
            String splited[] = data.get(i).getMeter_date().split(",");
            String dia_mes[] = splited[0].split(" ");
            fecha = splited[1] + "-" + convertir_mes(dia_mes[0]) + "-" + dia_mes[1];
            String date = fecha.replace(" ", "");

            if (i == 0) {
                actual = date;
                fechas.add(date);
            }
            if (!actual.equalsIgnoreCase(date)) {
                fechas.add(date);
                actual = date;
            }

        }
        return fechas;
    }

    public double sumar_value(List<Medidor_dto> list) {
        double acum = 0;
        for (int i = 0; i < list.size(); i++) {
            acum = acum + list.get(i).getValue();
        }
        return acum;
    }

    public String convertir_mes(String mes) {
        String result = "";

        if (mes.equalsIgnoreCase("enero")) {
            result = "1";
        }
        if (mes.equalsIgnoreCase("febrero")) {
            result = "2";
        }
        if (mes.equalsIgnoreCase("marzo")) {
            result = "3";
        }
        if (mes.equalsIgnoreCase("abril")) {
            result = "4";
        }
        if (mes.equalsIgnoreCase("mayo")) {
            result = "5";
        }
        if (mes.equalsIgnoreCase("junio")) {
            result = "6";
        }
        if (mes.equalsIgnoreCase("julio")) {
            result = "7";
        }
        if (mes.equalsIgnoreCase("agosto")) {
            result = "8";
        }
        if (mes.equalsIgnoreCase("septiembre")) {
            result = "9";
        }
        if (mes.equalsIgnoreCase("octubre")) {
            result = "10";
        }
        if (mes.equalsIgnoreCase("noviembre")) {
            result = "11";
        }
        if (mes.equalsIgnoreCase("diciembre")) {
            result = "12";
        }

        return result;
    }

}

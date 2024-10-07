package org.seguridad.seguridad.clima.models;

import lombok.Data;

import java.util.List;

@Data
public class PronosticoResponse {
    private String ciudad;
    private List<Pronostico> list;

    @Data
    public static class Pronostico {
        private String dt_txt;
        private Main main;

    }

    @Data
    public static class Main {
        private double temp;
        private double temp_min;
        private double temp_max;
        private double pressure;
        private double humidity;
    }
}

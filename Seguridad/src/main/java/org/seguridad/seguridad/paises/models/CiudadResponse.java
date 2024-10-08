package org.seguridad.seguridad.paises.models;

import lombok.Data;

import java.util.List;

@Data
public class CiudadResponse {
    List<Ciudad> geonames;
}

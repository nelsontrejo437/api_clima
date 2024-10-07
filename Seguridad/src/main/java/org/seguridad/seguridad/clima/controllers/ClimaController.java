package org.seguridad.seguridad.clima.controllers;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.seguridad.seguridad.clima.models.ClimaResponse;
import org.seguridad.seguridad.clima.models.ContaminacionResponse;
import org.seguridad.seguridad.clima.models.PronosticoResponse;
import org.seguridad.seguridad.clima.services.ClimaService;
import org.seguridad.seguridad.models.RegistroConsulta;
import org.seguridad.seguridad.models.Usuarios;
import org.seguridad.seguridad.paises.models.Ciudad;
import org.seguridad.seguridad.paises.models.Pais;
import org.seguridad.seguridad.paises.services.GeonamesServices;
import org.seguridad.seguridad.service.UsuariosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clima")
@CrossOrigin(origins = {"*"})
public class ClimaController {

    private ClimaService service;
    private GeonamesServices geonamesServices;

    @Autowired
    public ClimaController(final ClimaService service, final GeonamesServices geonamesServices) {
        this.service = service;
        this.geonamesServices = geonamesServices;
    }

    @GetMapping("/{ciudad}")
    @RateLimiter(name = "apiRateLimiter")
    public ClimaResponse getClima(@PathVariable String ciudad) {
        return service.getClimaByCity(ciudad);
    }

    @GetMapping("/pronostico/{ciudad}")
    @RateLimiter(name = "apiRateLimiter")
    public PronosticoResponse getClimaForDay(@PathVariable String ciudad) {
        return service.getClimaForDayByCity(ciudad);
    }

    @GetMapping("/contaminacion/{ciudad}")
    @RateLimiter(name = "apiRateLimiter")
    public ContaminacionResponse getClimaForAirPullution(@PathVariable String ciudad) {
        return service.getClimaForAirPullByCity(ciudad);
    }

    @GetMapping("/paises")
    public List<Pais> getPaises() {
        return geonamesServices.getPaises();
    }

    @GetMapping("/ciudades/{pais}")
    public List<Ciudad> getCiudadesByPais(@PathVariable String pais) {
        return geonamesServices.getCiudades(pais);
    }

}

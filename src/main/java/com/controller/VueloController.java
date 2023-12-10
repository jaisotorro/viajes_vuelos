package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Vuelo;
import com.service.VueloService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin("*")
@Tag(name="Servicio de vuelos", description="Servicio de consulta y actualización de vuelos")
public class VueloController {
	
	@Autowired
	VueloService vueloService;
	@Value("${eureka.instance.instance-id}")
	String instanceId;
	

 	@GetMapping(value="/vuelos-disponibles/{plazas}", produces=MediaType.APPLICATION_JSON_VALUE)
 	@Operation(summary="Busca vuelos disponibles", description="Busca todos los vuelos disponibles para el numero de plazas recibido")
	List<Vuelo> buscaDisponibles(@Parameter(name="plazas", description = "Nº de plazas para buscar los vuelos disponibles") @PathVariable(value="plazas") Integer plazasSolicitadas){
		System.out.println("En buscaDisponibles, instanceId: "+instanceId);
 		return vueloService.findDisponibles(plazasSolicitadas);
 	}

 	@PutMapping("vuelo/{id}/{plazas}")
 	@Operation(summary="Actualiza un vuelo", description="Actualización de las plazas disponibles del vuelo recibido, restando las plazas recibidas")
	void actualizaPlazasVuelo(@Parameter(name="id", description = "Id del vuelo a actualizar") @PathVariable(value="id") Integer idVuelo, @Parameter(name="plazas", description = "Nº de plazas a restar de la disponibilidad del vuelo") @PathVariable(value="plazas") Integer plazasReservadas) {
		System.out.println("En actualizaPlazasVuelo, instanceId: "+instanceId);
 		vueloService.updatePlazasVuelo(idVuelo, plazasReservadas);
	}

}

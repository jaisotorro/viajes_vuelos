package com.service;

import java.util.List;


import com.model.Vuelo;

public interface VueloService {
	List<Vuelo> findDisponibles(Integer plazasSolicitadas);
	void updatePlazasVuelo(Integer idVuelo, Integer plazasReservadas);
}

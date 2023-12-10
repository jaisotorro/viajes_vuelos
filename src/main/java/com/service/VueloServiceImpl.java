package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Vuelo;
import com.repository.VueloRepository;

@Service
public class VueloServiceImpl implements VueloService {

	@Autowired
	VueloRepository vueloRepository;
	
	@Override
	public List<Vuelo> findDisponibles(Integer plazasSolicitadas) {
		return vueloRepository.findDisponibles(plazasSolicitadas);
	}

	@Override
	public void updatePlazasVuelo(Integer idVuelo, Integer plazasReservadas) {
		vueloRepository.updatePlazasVuelo(idVuelo, plazasReservadas);
	}

}

package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.model.Vuelo;

public interface VueloRepository extends JpaRepository<Vuelo, Integer> {
	@Query("SELECT v FROM Vuelo v WHERE v.plazasDisponibles >= ?1")
	List<Vuelo> findDisponibles(Integer plazasSolicitadas);
	
	@Transactional
	@Modifying
	@Query("UPDATE Vuelo v SET v.plazasDisponibles = plazasDisponibles - ?2 WHERE v.idVuelo = ?1")
	void updatePlazasVuelo(Integer idVuelo, Integer plazasReservadas);
}

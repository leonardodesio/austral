package com.austral.model;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


@Transactional
public interface ComponentRepository extends CrudRepository<DatoXML,Long> {
	

	@Query(value="select * from TIN_Interfaces WHERE inte_Estado='N' LIMIT 1", nativeQuery = true)
	public List<DatoXML> obtenerNuevas();
	
	
	@Modifying
	@Query(value = "UPDATE TIN_Interfaces set inte_Estado =:estado where inte_Codigo =:codigo LIMIT 1",
            nativeQuery = true)
	public void actualizaEstado(@Param("codigo") Long codigo, @Param("estado") String estado);
	
	
}
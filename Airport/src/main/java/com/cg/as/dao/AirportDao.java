package com.cg.as.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.as.dto.Airport;
@Repository
public interface AirportDao extends JpaRepository<Airport,String>
{
	
}
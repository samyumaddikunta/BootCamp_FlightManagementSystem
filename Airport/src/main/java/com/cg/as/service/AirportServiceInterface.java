package com.cg.as.service;
import java.util.List;
import java.util.Optional;

import com.cg.as.dto.Airport;
public interface AirportServiceInterface
{
	public Airport addAirport(Airport airport);
	public void updateAirport(Airport airport);
	public Optional<Airport> viewAirport(String airportCode);
	public void deleteAirport(String airportCode);
	public List<Airport> viewAirports();
	//public boolean isAirportExist(String airportCode);
}	

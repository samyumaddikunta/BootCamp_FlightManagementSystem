package com.cg.as.service;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.as.dto.Airport;
import com.cg.as.dao.AirportDao;
@Service
@Transactional
public class AirportService implements AirportServiceInterface
{
	@Autowired(required = true)
	AirportDao airportDao;
	
    //To add Airport	
	@Override
	public Airport addAirport(Airport airport)
    {
		 return airportDao.save(airport);
	}
	
    //To update Airport By Id	
    @Override
    public void updateAirport(Airport airport)
    {
		Airport a = airportDao.findById(airport.getAirportCode()).get();
		a.setAirportName(airport.getAirportName());
		a.setAirportLocation(airport.getAirportLocation());

	}
    
    //To view Airport By Id    
	@Override
	public Optional<Airport> viewAirport(String airportCode)
	{
		return airportDao.findById(airportCode);
	}
	
	//To delete Airport By Id   
	@Override
	public void deleteAirport(String airportCode)
	{
		airportDao.deleteById(airportCode);	
    }
	
    //To view All Airports	
	@Override
	public List<Airport> viewAirports()
    {	
			return airportDao.findAll();
	}
	
	/*
	 * @Override public boolean isAirportExist(String airportCode) {
	 * if(airportDao.existById(airportCode)) { return true; } return false; }
	 */
		
}
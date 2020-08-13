package com.cg.as.controller;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.as.dto.Airport;
import com.cg.as.exception.AirportNotFoundException;
import com.cg.as.service.AirportService;
import com.cg.as.dao.AirportDao;

@RequestMapping("/airport")
@RestController
@CrossOrigin("http://localhost:4200")
public class AirportController {	
	
	@Autowired
	private AirportService airportService;
	
	@Autowired
	private AirportDao airportDao;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AirportController.class);

	
	    //add Airport	
		@PostMapping("/addAirport")
		public ResponseEntity<Object> addAirport(@Valid @RequestBody Airport airport)
		{
				try {
					airportService.addAirport(airport);
					LOGGER.info("Add airport method is accessed"); 
					return new ResponseEntity<>("Airport details added",HttpStatus.OK);
				} 
				catch (DataIntegrityViolationException ex) {
					return new ResponseEntity<>(ex.getMessage() + " Airport Already Exists", HttpStatus.BAD_REQUEST);
				}
			
		}
				
		//update Airport
		@PutMapping("/updateAirport/{id}")
		public ResponseEntity<Object> updateAirport(@PathVariable("id") String airportCode, @RequestBody Airport airport)throws AirportNotFoundException
		{
			if (airportDao.existsById(airportCode))
			{
				airportService.updateAirport(airport);
				LOGGER.info("update airport method is accessed");
				return new ResponseEntity<>("Airport is updated successsfully", HttpStatus.OK);
			}
			else
			{
				throw new AirportNotFoundException();
			}
		}
		

		//view Airport By Id
		@GetMapping("/viewAirport/{id}")
		public ResponseEntity<Object> viewAirport(@PathVariable("id") String airportCode)
		{
		    Optional<Airport> airport = airportDao.findById(airportCode);
		    if (airport.isPresent())
		    {
		      LOGGER.info("View Airport method is accessed");	
		      return new ResponseEntity<>(airport.get(), HttpStatus.OK);
		    }
		    else
		    {
		      return new ResponseEntity<>("Airport not found",HttpStatus.NOT_FOUND);
		    }
		 }
		
		
		//view Airports
		@GetMapping("/viewAirport")
		public ResponseEntity<Object> viewAirports()
		{
			List<Airport> airportList = airportService.viewAirports();
			LOGGER.info("View Airports method is accessed");
			return new ResponseEntity<>(airportList, HttpStatus.OK);
		}

		
		//Delete Airport By Id
		@DeleteMapping("/deleteAirport/{id}")
		public ResponseEntity<Object> deleteAirport(@PathVariable("id") String airportCode)throws AirportNotFoundException
		{
			if (airportDao.existsById(airportCode))
			{
				airportService.deleteAirport(airportCode);
				LOGGER.info("delete Airport method is accessed");
				return new ResponseEntity<>("Airport is deleted successsfully", HttpStatus.OK);
			}
			else
			{
				throw new AirportNotFoundException();
			}
		}
}		

		
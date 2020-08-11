package com.cg.fs.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.cg.fs.dto.FlightSchedule;
import com.cg.fs.exception.FlightScheduleNotFoundException;
import com.cg.fs.service.FlightScheduleService;
import com.cg.fs.dao.FlightScheduleDao;

@RequestMapping("/flightSchedule")
@RestController
@CrossOrigin("http://localhost:4200")
public class FlightScheduleController {	
	
	@Autowired
	private FlightScheduleService flightScheduleService;
	
	@Autowired
	private FlightScheduleDao flightScheduleDao;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FlightScheduleController.class);

	
	   //add FlightSchedule	
	   @PostMapping("/addFlightSchedule")
	   public ResponseEntity<Object> addFlightSchedule(@Valid @RequestBody FlightSchedule flightSchedule)
		{
	
			try {
				LOGGER.warn("Request {}", flightSchedule);
				flightScheduleService.addFlightSchedule(flightSchedule);
				return new ResponseEntity<>("Flight Schedule details added",HttpStatus.OK);
			} 
			catch (Exception ex) {
				return new ResponseEntity<>(ex.getMessage() + "Flight Schedule details already added", HttpStatus.BAD_REQUEST);
			}
		}
		
		//update Flight schedule
		@PutMapping("/updateFlightSchedule/{id}")
		public ResponseEntity<Object> updateFlightSchedule(@PathVariable("id") String scheduleId, @RequestBody FlightSchedule flightSchedule)
		{
			if (flightScheduleDao.existsById(scheduleId))
			{
				flightScheduleService.updateFlightSchedule(flightSchedule);
				return new ResponseEntity<>("Flight Schedule is updated successsfully", HttpStatus.OK);
			}
			else
			{
				throw new FlightScheduleNotFoundException();
			}
		}
		

		//view Flight Schedule By Id
		@GetMapping("/viewFlightSchedule/{id}")
		public ResponseEntity<Object> viewFlightSchedule(@PathVariable("id") String scheduleId)
		{
		    Optional<FlightSchedule> flightSchedule= flightScheduleDao.findById(scheduleId);
		    if (flightSchedule.isPresent())
		    {
		      return new ResponseEntity<>(flightSchedule.get(), HttpStatus.OK);
		    }
		    else
		    {
		      return new ResponseEntity<>("Flight Schedule not found",HttpStatus.NOT_FOUND);
		    }
		 }
		
		
		//view FlightSchedules
		@GetMapping("/viewFlightSchedule")
		public ResponseEntity<Object> viewFlightSchedules()
		{
			List<FlightSchedule> flightScheduleList = flightScheduleService.viewFlightSchedules();
			return new ResponseEntity<>(flightScheduleList, HttpStatus.OK);
		}

		
		//Delete Flight Schedule By Id
		@DeleteMapping("/deleteFlightSchedule/{id}")
		public ResponseEntity<Object> deleteFlightSchedule(@PathVariable("id") String scheduleId)
		{
			if (flightScheduleDao.existsById(scheduleId))
			{
				flightScheduleService.deleteFlightSchedule(scheduleId);
				return new ResponseEntity<>("Flight Schedule is deleted successsfully", HttpStatus.OK);
			}
			else
			{
				throw new FlightScheduleNotFoundException();
			}
		}
}		

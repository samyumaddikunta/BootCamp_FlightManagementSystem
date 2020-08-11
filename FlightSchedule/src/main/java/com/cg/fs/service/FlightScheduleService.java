package com.cg.fs.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.fs.dao.FlightScheduleDao;
import com.cg.fs.dto.FlightSchedule;
@Service
@Transactional
public class FlightScheduleService implements FlightScheduleInterface {

	@Autowired(required = true)
	FlightScheduleDao flightScheduleDao;
	
	    //To add FlightSchedule	
		@Override
		public FlightSchedule addFlightSchedule(FlightSchedule flightSchedule)
	    {
			 return flightScheduleDao.save(flightSchedule);
		}
		
	    //To view All FlightSchedules	
		@Override
		public List<FlightSchedule> viewFlightSchedules()
	    {	
				return flightScheduleDao.findAll();
		}

		//To update FlightSchedule By Id
		@Override
		public void updateFlightSchedule(FlightSchedule flightSchedule)
		{
			FlightSchedule f = flightScheduleDao.findById(flightSchedule.getScheduleId()).get();
			f.setFare(flightSchedule.getFare());
			f.setArrival(flightSchedule.getArrival());
			f.setDeparture(flightSchedule.getDeparture());
		}

		//To view FlightSchedule By Id
		@Override
		public Optional<FlightSchedule> viewFlightSchedule(String scheduleId) 
		{
			return flightScheduleDao.findById(scheduleId);
		}

		//To delete FlightSchedule By Id
		@Override
		public void deleteFlightSchedule(String scheduleId) {

			flightScheduleDao.deleteById(scheduleId);
			
		}
		
}

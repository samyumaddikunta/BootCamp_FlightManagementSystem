package com.cg.fs.service;
import java.util.List;
import java.util.Optional;
import com.cg.fs.dto.FlightSchedule;
public interface FlightScheduleInterface 
{
	public FlightSchedule addFlightSchedule(FlightSchedule flightSchedule);
	public void updateFlightSchedule(FlightSchedule flightSchedule);
	public Optional<FlightSchedule> viewFlightSchedule(String scheduleId );
	public void deleteFlightSchedule(String scheduleId);
	public List<FlightSchedule> viewFlightSchedules();
}

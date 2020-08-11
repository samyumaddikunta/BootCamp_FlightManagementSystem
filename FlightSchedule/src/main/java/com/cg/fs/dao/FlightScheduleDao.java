package com.cg.fs.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.fs.dto.FlightSchedule;
@Repository
public interface FlightScheduleDao extends JpaRepository<FlightSchedule,String>
{
	
}
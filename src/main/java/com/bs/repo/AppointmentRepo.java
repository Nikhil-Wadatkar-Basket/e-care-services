package com.bs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bs.beans.AppointmentDetails;

@Repository
public interface AppointmentRepo extends JpaRepository<AppointmentDetails, Integer> {

	public AppointmentDetails findAppointmentDetailsByAppTime(String time);

	public AppointmentDetails findAppointmentDetailsByUserID(Integer id);

	
}

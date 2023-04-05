package com.bs.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bs.beans.AppointmentDetails;

@Repository
public interface AppointmentRepo extends JpaRepository<AppointmentDetails, Integer> {

	AppointmentDetails findAppointmentDetailsByAppTime(String appTime);

//	AppointmentDetails findAppointmentDetailsByAppTime(Integer id);

}

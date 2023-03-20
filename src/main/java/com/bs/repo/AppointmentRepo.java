package com.bs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bs.beans.AppointmentDetails;
import com.bs.beans.UserDetails;

@Repository
public interface AppointmentRepo extends JpaRepository<AppointmentDetails, Integer> {

}

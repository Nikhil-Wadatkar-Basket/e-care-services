package com.bs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bs.beans.VisitingDoctorDetails;

@Repository
public interface VisitingDoctorRepo extends JpaRepository<VisitingDoctorDetails, Integer> {

}

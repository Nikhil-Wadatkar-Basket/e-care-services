package com.bs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bs.beans.PatientDetails;

@Repository
public interface PatientRepo extends JpaRepository<PatientDetails, Integer> {

}

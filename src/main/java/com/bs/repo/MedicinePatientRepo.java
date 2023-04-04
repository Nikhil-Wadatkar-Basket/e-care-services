package com.bs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bs.beans.MedicineDetails;
import com.bs.beans.MedicinePatient;

@Repository
public interface MedicinePatientRepo extends JpaRepository<MedicinePatient, Integer> {

}

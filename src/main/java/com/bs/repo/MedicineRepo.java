package com.bs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bs.beans.MedicineDetails;

@Repository
public interface MedicineRepo extends JpaRepository<MedicineDetails, Integer> {

}

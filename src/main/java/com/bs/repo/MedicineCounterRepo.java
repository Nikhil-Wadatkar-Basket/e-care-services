package com.bs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bs.beans.MedicineCounter;

@Repository
public interface MedicineCounterRepo extends JpaRepository<MedicineCounter, Integer> {

}

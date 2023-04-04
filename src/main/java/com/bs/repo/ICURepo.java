package com.bs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bs.beans.ICUDetails;

@Repository
public interface ICURepo extends JpaRepository<ICUDetails, Integer> {
	ICUDetails findICUDetailsByBedNumber(Integer number);
}

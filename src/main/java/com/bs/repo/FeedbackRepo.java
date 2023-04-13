package com.bs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bs.beans.FeedbackDetails;

@Repository
public interface FeedbackRepo extends JpaRepository<FeedbackDetails, Integer> {

}

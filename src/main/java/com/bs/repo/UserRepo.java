package com.bs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bs.beans.UserDetails;

@Repository
public interface UserRepo extends JpaRepository<UserDetails, Integer> {

}

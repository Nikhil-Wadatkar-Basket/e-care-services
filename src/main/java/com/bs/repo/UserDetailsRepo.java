package com.bs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bs.beans.UserDetails;

@Repository
public interface UserDetailsRepo extends JpaRepository<UserDetails, String> {
//	@Query(value = "select ud from UserDetails ud where ud.userName like '%:userName' and password  like '%:password'",nativeQuery = false)
	UserDetails findUserDetailsByUserNameAndPassword(String userName,String password);
}

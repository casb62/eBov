package com.casb.eBov.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.casb.eBov.model.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
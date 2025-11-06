package com.casb.eBov.model.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.casb.eBov.model.domain.User;
import com.casb.eBov.model.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public User bring(Integer id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
package com.casb.eBov.model.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.casb.eBov.model.domain.User;
import com.casb.eBov.model.repositories.UserRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Transactional
    public User save(User user) {
        if (userRepository.existsByLogin(user.getLogin())) {
            throw new RuntimeException("Login already exists: " + user.getLogin());
        }
        return userRepository.save(user);
    }

    @Transactional
    public User update(Integer id, User userDetails) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        if (!user.getLogin().equals(userDetails.getLogin()) &&
            userRepository.existsByLogin(userDetails.getLogin())) {
            throw new RuntimeException("Login already exists: " + userDetails.getLogin());
        }

        user.setLogin(userDetails.getLogin());
        user.setPassword(userDetails.getPassword());
        return userRepository.save(user);
    }

    @Transactional
    public void deleteById(Integer id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }
}
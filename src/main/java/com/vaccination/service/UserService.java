package com.vaccination.service;

import org.springframework.stereotype.Service;

import com.vaccination.entity.User;
import com.vaccination.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void registerUser(User user) {
		userRepository.save(user);
	}
}

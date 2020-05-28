package com.jspring1.demo.service;

import java.util.Optional;

import com.jspring1.demo.model.UserModel;
import com.jspring1.demo.repo.Role;
import com.jspring1.demo.repo.SequenceCustomRepository;
import com.jspring1.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jspring1.demo.model.User;



import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	private final static String COLLECTION_SEQ = "user_seq";
	@Autowired
	private SequenceCustomRepository sequenceCustomRepository;

	@Autowired
	private UserRepository userRepository;

	public Optional<User> getUserByName(String username) {
		return userRepository.findByUsername(username);
	}

	public User create(UserModel userModel) {
		User user = User.build(sequenceCustomRepository.getNextSeqId(COLLECTION_SEQ), userModel.getPassword(), userModel.getName(), Role.USER);
		return userRepository.save(user);
	}

}

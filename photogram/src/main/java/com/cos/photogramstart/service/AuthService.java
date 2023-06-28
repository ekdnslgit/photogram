package com.cos.photogramstart.service;

import org.springframework.stereotype.Service;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service // 1. IoC 2. 트랜잭션 관리
public class AuthService {
	
	private final UserRepository userRepository;

	public User 회원가입(User user) {
		// 회원가입 진행
		User userEntity = userRepository.save(user); // Entitiy를 쓰는 이유는 save가 된 뒤에(DB에 넣고) 응답받은 것이다.
		return userEntity;
	}
	
}

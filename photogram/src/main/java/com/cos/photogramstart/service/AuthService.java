package com.cos.photogramstart.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service // 1. IoC 2. 트랜잭션 관리
public class AuthService {
	
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Transactional // Write(insert, update, delete)할 때 붙인다.
	public User 회원가입(User user) {
		// 회원가입 진행
		String rawPassword = user.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword); // 암호화된 패스워드
		user.setPassword(encPassword);
		user.setRole("ROLE_USER"); // 회원가입하는 모든 유저들에게 유저라는 권한을 부여, 관리자는 ROLE_ADMIN 부여 예정
		User userEntity = userRepository.save(user); // Entitiy를 쓰는 이유는 save가 된 뒤에(DB에 넣고) 응답받은 것이다.
		return userEntity;
	}
	
}

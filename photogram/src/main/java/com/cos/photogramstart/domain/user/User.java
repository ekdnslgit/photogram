package com.cos.photogramstart.domain.user;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedEntityGraph;
import javax.persistence.PrePersist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// JPA - Java Persistence API (자바로 데이터를 DB에 영구적으로 저장할 수 있는 API를 제공)

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity // DB에 테이블을 생성
public class User {
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 번호 증가 전략이 데이터베이스를 따라간다.
	private int id;
	
	@Column(length = 20, unique = true) // 제약조건 부여, 이름 최대 글자 수 설정 / 유저네임 중복 가입 방지(스키마(테이블) 변경)
	private String username;                     // 어플리케이션.yml에 JPA를 create로 한번 바꿔줘야함
	@Column(nullable=false)
	private String password;
	@Column(nullable=false)
	private String name;
	private String website;
	private String bio;
	@Column(nullable=false)
	private String email;
	private String phone;
	private String gender;
	private String profileImageUrl;
	private String role; // 권한
	
	private LocalDateTime createDate;
	
	@PrePersist // DB에 Data가 insert되기 직전에 걸어줌, 위의 필드만 넣어주면 자동으로 createdate
	public void createDate() {
		this.createDate = LocalDateTime.now();
	}

}

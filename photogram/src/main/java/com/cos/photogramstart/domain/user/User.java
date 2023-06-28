package com.cos.photogramstart.domain.user;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedEntityGraph;
import javax.persistence.PrePersist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// JPA - Java Persistence API (자바로 데이터를 DB에 영구적으로 저장할 수 있는 API를 제공)

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity // DB에 테이블을 생성
public class User {
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 번호 증가 전략이 데이터베이스를 따라간다.
	private int id;
	
	private String username;
	private String password;
	private String name;
	private String website;
	private String bio;
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

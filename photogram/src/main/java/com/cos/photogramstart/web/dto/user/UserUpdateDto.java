package com.cos.photogramstart.web.dto.user;

import com.cos.photogramstart.domain.user.User;

import lombok.Data;

@Data
public class UserUpdateDto {

	private String name; // 필수
	private String password; // 필수, 필수데이터가 아닌것은 엔티티로 만들면 위험하다.
	private String website;
	private String bio;
	private String phone;
	private String gender;
	
	public User toEntity() {
		return User.builder()
			.name(name)
			.password(password)
			.website(website)
			.bio(bio)
			.phone(phone)
			.gender(gender)
			.build();
	}
	
}

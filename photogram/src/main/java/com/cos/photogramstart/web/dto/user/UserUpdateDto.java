package com.cos.photogramstart.web.dto.user;

import javax.validation.constraints.NotBlank;

import com.cos.photogramstart.domain.user.User;

import lombok.Data;

@Data
public class UserUpdateDto {
	@NotBlank
	private String name; // 필수
	@NotBlank
	private String password; // 필수, 필수데이터가 아닌것은 엔티티로 만들면 위험하다.
	private String website;
	private String bio;
	private String phone;
	private String gender;
	
	public User toEntity() {
		return User.builder()
			.name(name) // 밸리데이션 체크필요
			.password(password) // 사용자가 패스워드를 기재하지 않으면 문제가 됨(공백 등 입력) 밸리데이션 체크필요
			.website(website)
			.bio(bio)
			.phone(phone)
			.gender(gender)
			.build();
	}
	
}

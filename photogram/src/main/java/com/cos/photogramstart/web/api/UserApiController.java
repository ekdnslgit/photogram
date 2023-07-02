package com.cos.photogramstart.web.api;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.photogramstart.web.dto.user.UserUpdateDto;

@RestController  // api controller는 전부 레스트 컨트롤러다.(데이터 응답), 제이쿼리는 데이터로 응답.
public class UserApiController {

	@PutMapping("/api/user/{id}")
	public String update(UserUpdateDto userUpdateDto) {
		System.out.println(userUpdateDto);
		return "ok";
	}
}

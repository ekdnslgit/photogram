package com.cos.photogramstart.web.dto.image;

import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import com.cos.photogramstart.domain.image.Image;
import com.cos.photogramstart.domain.user.User;

import lombok.Data;

@Data
public class ImageUploadDto {
	
	private MultipartFile file; // MultipartFile에서는 @NotBlank 어노테이션을 사용할 수 없다
	private String caption;
	
	public Image toEntity(String postImageUrl, User user) {
		return Image.builder()
				.caption(caption)
				.postImageUrl(postImageUrl) // 파일의 경로를 받아와야하는데 uuid 때문에 못 읽어와서 함수의 매개변수를 입력해서 받아온다.
				.user(user)
				.build();
	}
	
}

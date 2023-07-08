package com.cos.photogramstart.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cos.photogramstart.config.auth.PrincipalDetails;
import com.cos.photogramstart.domain.image.Image;
import com.cos.photogramstart.domain.image.ImageRepository;
import com.cos.photogramstart.web.dto.image.ImageUploadDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // 의존성 주입을 위해 사용
@Service
public class ImageService {
	
	private final ImageRepository imageRepository;
	
	@Value("${file.path}") // 어플리케이션.yml 파일의 맨 마지막 적힌 부분의 파일 경로를 읽어온다.
	private String uploadFolder;

	public void 사진업로드(ImageUploadDto imageUploadDto, PrincipalDetails principalDetails) {
		UUID uuid = UUID.randomUUID(); // uuid는 db에 파일경로(파일이름 포함)를 저장할 때, 똑같은 파일명이 들어오면 구분해주는 역할을 한다.(네트워크상 고유성 보장 id 만들기)
		String imageFileName = uuid + "_" + imageUploadDto.getFile().getOriginalFilename(); // 1.jpg / 실제 파일 네임이 imageFileName에 들어간다
		// 앞에 uuid를 더해준 이유는 uuid를 한번 더 넣음으로써 더욱 완벽한 유일성을 보장하기 위해서이다.
		// System.out.println("이미지 파일이름: " + imageFileName);
		
		Path imagefilePath = Paths.get(uploadFolder + imageFileName); // 경로+파일명
		
		// 통신, I/O(하드디스크에 기록을 하거나 읽을 때) -> 예외가 발생할 수 있음
		try {
			Files.write(imagefilePath, imageUploadDto.getFile().getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// image 테이블에 저장
		Image image = imageUploadDto.toEntity(imageFileName, principalDetails.getUser()); // 6d39d1ae-83fc-474f-941f-926a1549208c_캡처.PNG
		Image imageEntity = imageRepository.save(image);
		
		// System.out.println(imageEntity);
	}
	
}

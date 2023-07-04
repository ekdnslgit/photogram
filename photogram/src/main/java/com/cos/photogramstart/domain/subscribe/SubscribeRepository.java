package com.cos.photogramstart.domain.subscribe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface SubscribeRepository extends JpaRepository<Subscribe, Integer>{

	@Modifying // 데이터베이스에 변경을 주는 네이티브 쿼리에 사용한다(인서트, 딜리트, 업데이트를 네이티브 쿼리고 작성하려고 할 때 필요!
	@Query(value = "INSERT INTO subscribe(fromUserId, toUserId, createDate) VALUES(:fromUserId, :toUserId, now())", nativeQuery = true) // 네이티브 쿼리를 적을 수 있게함
	void mSubscribe(int fromUserId, int toUserId); // 네이티브 쿼리(내가 쿼리를 짜는 것)
	
	@Modifying
	@Query(value = "DELETE FROM subscribe WHERE fromUserId = :fromUserId AND toUserId = :toUserId", nativeQuery = true) // : 의 의미는 아래 변수를 바인드해서 넣겠다는 문법
	void mUnSubscribe(int fromUserId, int toUserId);

}

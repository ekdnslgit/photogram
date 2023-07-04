// (1) 회원정보 수정
function update(userId, event) {
	event.preventDefault(); // 폼태그 액션을 막는 것(업데이트 jsp파일)
	let data = $("#profileUpdate").serialize(); // 헤더에 제이쿼리를 정의해놓았기 떄문에 쓸 수 있음 profileUpdate는 id(update.jsp의 프로필 수정 영역)값을 의미함
	// 이 폼태그를 잦아서 이 폼테그가 들고있는 모든 인포값들을 시리얼라이즈하면 데이터에 담긴다.
	
	console.log(data);
	
	$.ajax({
		type : "put",
		url : `/api/user/${userId}`,
		data : data,
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		dataType : "json"
		
	}).done(res=> { // "json"을 파싱해서 받는다. res는 자바스크립트 오브젝트가 된다. / httpstatus 상태코드 200번대면 done이 뜬다.
		console.log("성공", res);
		location.href = `/user/${userId}`;
	}).fail(error=> { // httpstatus 상태코드 200번때가 아닐 때 뜬다.
	console.log(error);
		if(error.data == null) {
			alert(error.responseJSON.message);
		} else {
		alert(JSON.stringify(error.responseJSON.data)); // stringify는 괄호 안의 자바스크립트 오브젝트를 제이슨 문자열로 변환하는 기능을 수행
		}
	});
}

// 리스폰스 엔티티를 쓰는 이유는 에이젝스 통신을 할 때는 리스폰스 엔티티를 써줘야 http 상태코드를 전달할 수 있다.(done / fail)
package com.cos.photogramstart.util;

public class Script {

	public static  String back(String msg) {
		StringBuffer sb = new StringBuffer();
		sb.append("<script>");
		sb.append("alert('"+msg+"');"); // 변수를 넣으려면 ' "+내용+" ' 해야한다
		sb.append("history.back();");
		sb.append("</script>");
		
		return sb.toString();
	}
	
}

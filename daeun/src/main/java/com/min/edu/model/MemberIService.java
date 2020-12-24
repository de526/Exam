package com.min.edu.model;

import java.util.Map;

import com.min.edu.dto.MemberDTO;

public interface MemberIService {

	// 회원가입
	public boolean signUpMember(MemberDTO dto);

	// 아이디 중복체크 0이면 true로 처리
	public int idDuplicateCheck(String id);

	// 아이디, 패스워드 맵에 담아서 로그인
	public MemberDTO loginMember(Map<String, String> map);

}

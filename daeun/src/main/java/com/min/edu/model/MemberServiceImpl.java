package com.min.edu.model;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberIService {

	@Autowired
	private MemberIDao dao;

	@Override
	public boolean signUpMember(MemberDTO dto) {
		return dao.signUpMember(dto);
	}

	@Override
	public int idDuplicateCheck(String id) {
		return dao.idDuplicateCheck(id);
	}

	@Override
	public MemberDTO loginMember(Map<String, String> map) {
		return dao.loginMember(map);
	}
}

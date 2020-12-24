package com.min.edu.model;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.min.edu.dto.MemberDTO;

@Repository
public class MemberDaoImpl implements MemberIDao {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public boolean signUpMember(MemberDTO dto) {
		String enPassword = passwordEncoder.encode(dto.getPw());
		log.info("암호화된 비밀번호 :"+ enPassword);
		dto.setPw(enPassword);
		return sqlSession.insert("member.signUpMember",dto)>0?true:false;
	}

	@Override
	public int idDuplicateCheck(String id) {
		return sqlSession.selectOne("member.idDuplicateCheck",id);
	}

	@Override
	public MemberDTO loginMember(Map<String, String> map) {
//		return sqlSession.selectOne("member.loginMember",map);
		
		MemberDTO mDto = null;
		log.info("받아온 pw : "+ map.get("pw"));
		String enPw = passwordEncoder.encode((String)map.get("pw"));
		log.info("암호화된 pw :"+ enPw);
	
		
		//id로 db에 있는 pw 가져오기
		String dbPw = sqlSession.selectOne("member.selStringPw", map.get("id"));
		log.info("DB에 입력되어 있는 pw :"+ dbPw);
		
		if(passwordEncoder.matches((String)map.get("pw"), dbPw)) {
			//matches(rawPassword, encoded)이다. 
			//rawPassword parameter에 암호화된 값을 넣지 말고, 사용자가 입력한 패스워드를 그대로 넣어주도록 하자
			log.info("dbPw와 받아온 pw 일치 확인");
			mDto = sqlSession.selectOne("member.enLogin", map);
		}
	      return mDto;
	}


}
